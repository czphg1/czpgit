package com.example.czp.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtil {
    public static Map<String,String> uploadFile(String uploadPath , MultipartFile...files) throws IOException {
        File upload = new File(uploadPath);
        if(!upload.exists()){
            upload.mkdirs();
        }
        Map<String , String> resultMap = new HashMap<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                File dest = new File(upload, System.currentTimeMillis()+"-"+fileName);
                file.transferTo(dest);
                resultMap.put(fileName,dest.getPath());
            }
        }
        return resultMap;

    }
    public static Object downloadFile(String filePath , String fileName)throws Exception{
        File file = new File(filePath);
        if(!file.exists()){
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //最后一个charset会把filename转为%模式的URL字符串，并且header中的filename会写成filename*=UTF-8''文件名
        if (StringUtils.isEmpty(fileName)) {
            headers.setContentDispositionFormData("attachment", file.getName(), Charset.forName("UTF-8"));
        }else {
            headers.setContentDispositionFormData("attachment", fileName, Charset.forName("UTF-8"));
        }
        return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.CREATED);
    }
}
