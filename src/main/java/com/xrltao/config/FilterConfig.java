package com.xrltao.config;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mengqh
 * @version 1.0
 * @date 2019/12/15 1:10
 * @Description
 */
@Configuration
public class FilterConfig {
    /*
     * @author mengqh
     * @date 2019/12/15 1:09
     * @param []
     * @return FilterRegistrationBean
     * @description 使用WebStatFilter配置一个druid的filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        //添加过滤器
        filterFilterRegistrationBean.setFilter(new WebStatFilter());

        //设置初始化参数
        Map<String, String> initParam = new HashMap<>();
        //设置不拦截的请求
        initParam.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*");
        //设置初始化参数
        filterFilterRegistrationBean.setInitParameters(initParam);

        //设置拦截请求
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterFilterRegistrationBean;
    }
}
