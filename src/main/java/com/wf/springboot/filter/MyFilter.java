/**
 * Copyright (C), 2015-2019, 王飞
 * FileName: MyFilter
 * Author:   WF
 * Date:     2019/8/29 20:54
 * Description: 我自己的拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wf.springboot.filter;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

import javax.servlet.*;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈我自己的过滤器〉
 *
 * @author WF
 * @create 2019/8/29
 * @since 1.0.0
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    //执行过滤器
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process....");
        //放行请求
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
