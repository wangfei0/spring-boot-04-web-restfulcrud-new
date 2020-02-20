/**
 * Copyright (C), 2015-2019, 王飞
 * FileName: LoginController
 * Author:   WF
 * Date:     2019/8/28 20:27
 * Description: 处理登录请求
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈处理登录请求〉
 *
 * @author WF
 * @create 2019/8/28
 * @since 1.0.0
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if (!StringUtils.isEmpty(username) && "000".equals(password)){
           //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登陆失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
