package com.wjl.example.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.wjl.example.model.entity.User;
import com.wjl.example.service.intf.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wjl
 * @date: 2021/12/31 15:59
 * @version: v1.0
 */
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @param user user
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (userService.findUserByUsernameAndPassword(username, password) != null) {
            StpUtil.login(username);
            user.setToken(StpUtil.getTokenValue());
            return "success";
        } else {
            return "failed";
        }
    }

}
