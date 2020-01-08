package com.xrltao.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mengqh
 * @version 1.0
 * @date 2019/12/15 1:11
 * @Description
 */
@Configuration
public class ServletConfig {

    /*
     * @author mengqh
     * @date 2019/12/15 1:06
     * @param []
     * @return ServletRegistrationBean
     * @description 注入Druid的servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //配置/druid/*请求
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(
                new StatViewServlet(), "/druid/*"
        );
        //设置初始化参数值
        Map<String, String> initParam = new HashMap<>();
        //配置登录用户名
        initParam.put(StatViewServlet.PARAM_NAME_USERNAME, "root");
        //配置登录密码
        initParam.put(StatViewServlet.PARAM_NAME_PASSWORD, "1234");
        //如果不写，则默认所有ip都可以访问
        initParam.put(StatViewServlet.PARAM_NAME_ALLOW, "");
        //禁止访问的IP地址
        //initParam.put(StatViewServlet.PARAM_NAME_DENY, "192.168.3.8");
        //设置初始化参数
        bean.setInitParameters(initParam);
        return bean;
    }

}
