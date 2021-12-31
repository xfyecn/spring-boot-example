package com.wjl.example.component;

import cn.dev33.satoken.stp.StpInterface;
import com.wjl.example.model.entity.*;
import com.wjl.example.service.intf.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: wjl
 * @date: 2021/12/31 15:54
 * @version: v1.0
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RolePermissionService rolePermissionService;

    @Override
    public List<String> getPermissionList(Object loginId, String s) {
        User user = userService.findUserByUsername(loginId.toString());
        List<UserRole> userRoles = userRoleService.findRolesByUser(user);
        Set<String> permissions = new HashSet<>();
        for (UserRole userRole : userRoles) {
            Role role = roleService.findRoleById(userRole.getRid());
            List<RolePermission> rolePermissions = rolePermissionService.findAllByRole(role);
            for (RolePermission rolePermission : rolePermissions) {
                Permission permission = permissionService.findPermissionById(rolePermission.getPid());
                permissions.add(permission.getPermission());
            }
        }
        return new ArrayList<>(permissions);
    }

    @Override
    public List<String> getRoleList(Object loginId, String s) {
        User user = userService.findUserByUsername(loginId.toString());
        List<UserRole> userRoles = userRoleService.findRolesByUser(user);
        List<String> roles = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            roles.add(roleService.findRoleById(userRole.getRid()).getRole());
        }
        return roles;
    }

}
