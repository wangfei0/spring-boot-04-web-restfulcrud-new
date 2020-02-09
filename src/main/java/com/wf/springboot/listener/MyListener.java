/**
 * Copyright (C), 2015-2019, 王飞
 * FileName: MyListener
 * Author:   WF
 * Date:     2019/8/29 21:06
 * Description: 自定义的监听器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wf.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自定义的监听器〉
 *
 * @author WF
 * @create 2019/8/29
 * @since 1.0.0
 */
public class MyListener implements ServletContextListener {

    //初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized。。。web应用启动");
    }

    //销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed....当前web项目销毁");
    }
}
