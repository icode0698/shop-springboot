package com.newboot.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.common.CommonResult;
import com.newboot.shop.common.ResultMessage;
import com.newboot.shop.config.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/upload")
public class UploadController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/user")
    @ResponseBody
    public CommonResult uploadUserImg(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //命名文件
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String newFileName = sdf.format(new Date()) + suffixName;
        File fileDirectory = new File(ProjectConfig.getUserFileUploadPath());
        //创建文件
        File destFile = new File(ProjectConfig.getUserFileUploadPath() + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            //返回相对路径
            JSONObject json = new JSONObject();
            json.put("filePath", "headPic/" + newFileName);
            return CommonResult.success(ResultMessage.UPLOAD_FILE_SUCCESS.getMessage(), json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed(ResultMessage.UPLOAD_FILE_FAIL.getMessage());
    }
}
