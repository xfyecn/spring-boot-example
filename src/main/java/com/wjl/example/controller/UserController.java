package com.wjl.example.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wjl
 * @date: 2021/12/31 15:59
 * @version: v1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private StpInterface stpInterface;

    /**
     * roles
     *
     * @param username username
     */
    @SaCheckLogin
    @SaCheckRole("admin")
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<String> getAllRoles(@RequestParam String username) {
        return stpInterface.getRoleList(username, "user");
    }

    /**
     * permissions
     *
     * @param username username
     */
    @SaCheckRole("visitor")
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public List<String> getAllPermissions(@RequestParam String username) {
        return stpInterface.getPermissionList(username, "admin");
    }

}
