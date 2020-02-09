/**
 * Copyright (C), 2015-2019, 王飞
 * FileName: MyMvcConfig
 * Author:   WF
 * Date:     2019/8/28 9:52
 * Description: mvc配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wf.springboot.config;

import com.wf.springboot.component.LoginHandlerInterceptor;
import com.wf.springboot.component.MyLocalResolver;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.awt.*;
import java.beans.Customizer;

/**
 * 〈一句话功能简述〉<br>
 * 〈mvc配置〉
 *
 * @author WF
 * @create 2019/8/28
 * @since 1.0.0
 */

/**
 * @Configuration注解并表示这是一个配置类
 * 使用webMvcConfigurerAdapter可以来扩展Sprinfmvc的功能
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/ayguigu请求来到success
        registry.addViewController("/atguigu").setViewName("success");
    }

    //所有的webMvcConfigurerAdapter组件会一起起作用
    @Bean //註冊到容器去
    public WebMvcConfigurer webMvcConfigurerAdapter() {
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("Dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("login.html","/","/user/login","/css/**");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }
}
