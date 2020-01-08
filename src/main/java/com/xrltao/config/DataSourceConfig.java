package com.xrltao.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
/**
 * @author mengqh
 * @version 1.0
 * @date 2019/12/15 0:23
 * @Description 数据源配置类
 */
@Configuration
public class DataSourceConfig {

    /*
     * @author mengqh
     * @date 2019/12/15 1:05
     * @param []
     * @return javax.sql.DataSource
     * @description 将Druid数据源注入
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}
