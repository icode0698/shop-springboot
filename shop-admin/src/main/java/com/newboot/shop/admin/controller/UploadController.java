package com.newboot.shop.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.common.CommonResult;
import com.newboot.shop.admin.common.ResultMessage;
import com.newboot.shop.admin.config.ProjectConfig;
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
    @RequestMapping("/goods")
    @ResponseBody
    public CommonResult uploadGoodsImg(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //命名文件
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String newFileName = sdf.format(new Date()) + suffixName;
        File fileDirectory = new File(ProjectConfig.getGoodsFileUploadPath());
        //创建文件
        File destFile = new File(ProjectConfig.getGoodsFileUploadPath() + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            //返回相对路径
            JSONObject json = new JSONObject();
            json.put("filePath", "pic/" + newFileName);
            return CommonResult.success(ResultMessage.UPLOAD_FILE_SUCCESS.getMessage(), json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed(ResultMessage.UPLOAD_FILE_FAIL.getMessage());
    }
}
