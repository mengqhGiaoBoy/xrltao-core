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
        //设置为true时，会将RowBounds第一个offset当成pageNum页码使用
        p.setProperty("offsetAsPageNum","true");
        //设置为true时，RowBounds分页会进行count查询
        p.setProperty("rowBoundsWithCount","true");
        p.setProperty("reasonable","true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

}
