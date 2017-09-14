package com.example.czp.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

//pagehelper版本太新导致无法分页，一开始是5.1 后来改成4.1就正常了
@Configuration
public class MybatisConfiguration {
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum","true");
        p.setProperty("RowBoundsWithCount","true");
        p.setProperty("resonable","true");
        p.setProperty("dialect","mysql");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
