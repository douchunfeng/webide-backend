/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.ustc.webide.admin.config;

import com.ustc.webide.admin.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * Filter配置
 *
 * @author Mark sunlightcs@gmail.com
 */
@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean shiroFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
//        //该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
//        registration.addInitParameter("targetFilterLifecycle", "true");
//        registration.setEnabled(true);
//        registration.setOrder(Integer.MAX_VALUE - 1);
//        registration.addUrlPatterns("/*");
//        return registration;
//    }

    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setName("xssFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }
}
