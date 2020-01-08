package com.xrltao.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/5 16:47
 * @Description
 */
@Configuration
public class MybatisConfig {

    /*
     * @author mengqh
     * @date 2020/1/5 16:48
     * @param []
     * @return com.github.pagehelper.PageHelper
     * @description 配置分页插件
     */
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum","true");
        p.setProperty("rowBoundsWithCount","true");
        p.setProperty("reasonable","true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

}
