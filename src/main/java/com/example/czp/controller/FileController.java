package com.example.czp.controller;

import com.example.czp.util.FileUtil;
import com.example.czp.util.ResultMsg;
import org.apache.tomcat.util.descriptor.web.WebXml;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

@Controller
@RequestMapping("/file")
public class FileController {

    @Value("${uploadPath}")
    private String uploadPath;

    @RequestMapping("/upload")
    public String upload(HttpServletRequest request){
        System.out.println(uploadPath);
        System.out.println(request.getServletContext().getContextPath());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(this.getClass().getClassLoader().getResource(""));
        System.out.println(System.getProperty("user.dir"));

        return "upload";
    }
    @RequestMapping("/uploadfile")
    @ResponseBody()
    public ResultMsg uploadFile(MultipartFile[] file)throws Exception{
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setData(FileUtil.uploadFile(uploadPath,file));
        resultMsg.setSuccess();
        return resultMsg;
    }
    @RequestMapping("/download")
    @ResponseBody
    public Object download() throws Exception{
//        String filePath = uploadPath+File.separator+"QQ图片20170909153944.jpg";
        String filePath =uploadPath+File.separator+"123.txt";
        Object obj = FileUtil.downloadFile(filePath ,null);
        if(obj == null){
            ResultMsg msg = new ResultMsg();
            msg.setError();
            return msg;
        }else {
            return obj;
        }
    }
    @RequestMapping("/exception")
    @ResponseBody
    public void exception()throws Exception{
        throw new Exception();
    }
    @RequestMapping("zhongwen")
    @ResponseBody
    public String zhongwen(){
        return "中文";
    }
}
