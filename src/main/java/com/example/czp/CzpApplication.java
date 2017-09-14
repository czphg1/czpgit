package com.example.czp;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan("com.example.czp")
public class CzpApplication {

	public static void main(String[] args) {
		SpringApplication.run(CzpApplication.class, args);
	}
//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConverters(){
//		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//		FastJsonConfig config = new FastJsonConfig();
//		//格式化json数据
//		config.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue);
//
//		//解决中文乱码问题(并不需要)
////		List<MediaType> mediaTypes = new ArrayList<>();
////		mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
////		converter.setSupportedMediaTypes(mediaTypes);
//		//设置fastjson的配置
//		converter.setFastJsonConfig(config);
//		converter.setDefaultCharset(Charset.forName("UTF-8"));
//		HttpMessageConverter httpMessageConverter = converter;
//		return new HttpMessageConverters(httpMessageConverter);
//
//	}
}
