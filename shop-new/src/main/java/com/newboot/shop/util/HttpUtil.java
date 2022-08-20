package com.newboot.shop.util;


import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.config.ProjectConfig;
import org.apache.commons.lang3.StringUtils;
import org.lionsoul.ip2region.xdb.Searcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 判断当前请求是否是ajax请求
     *
     * @param request 请求对象
     * @return boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    /**
     * 获取当前请求的IP
     * @param request 请求
     * @return String
     *
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                try {
                    InetAddress inet = InetAddress.getLocalHost();
                    ipAddress = inet.getHostAddress();
                } catch (Exception e) {
                    logger.error("根据网卡获取本机配置的IP异常", e);
                }
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP，多个IP按照','分割
        if (ipAddress != null && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.split(",")[0];
        }
        // 对于本地开发验证的IP直接转为本地外网IP
        try {
            if (ipAddress != null && ipAddress.equals(InetAddress.getLocalHost().getHostAddress())){
                ipAddress = "39.128.36.43";
            }
        }catch (Exception e){
            logger.error("根据网卡获取本机配置的IP异常", e);
        }

        return ipAddress;
    }

    /**
     * 获取IP地址信息
     * @param ipAddress
     * @return String
     *
     */
    public static JSONObject getIpInfo(String ipAddress){
        JSONObject json = new JSONObject();
        // 并发使用，用整个 xdb 数据缓存创建的查询对象可以安全的用于并发，也就是你可以把这个 searcher 对象做成全局对象去跨线程访问。
        Searcher searcher = SpringContextUtil.getBean("getSearcher");
        try {
            long sTime = System.nanoTime();
            String region = searcher.search(ipAddress);
            long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
            json.put("ipRegion", region);
            json.put("ipCostTime", cost);
            json.put("ipIOCount", searcher.getIOCount());
            logger.info("{region: {}, ioCount: {}, took: {} μs}", region, searcher.getIOCount(), cost);
        } catch (Exception e) {
            logger.error("failed to search({}}): {}", ipAddress, e.toString());
        }
        return json;
    }

    public static String getIpPossession(String ipRegion) {
        if (StringUtils.isNotEmpty(ipRegion)) {
            String[] cityList = ipRegion.split("\\|");
            if (cityList.length > 0) {
                // 国内的显示到具体的省
                if (StringUtils.equals("中国", cityList[0])) {
                    if (cityList.length > 3) {
                        return cityList[2];
                    }
                }
                // 国外显示到国家
                return cityList[0];
            }
        }
        return "未知";
    }
}
