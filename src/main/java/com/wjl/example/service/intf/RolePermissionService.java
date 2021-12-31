package com.wjl.example.service.intf;

import com.wjl.example.model.entity.Role;
import com.wjl.example.model.entity.RolePermission;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/12/31 15:48
 * @version: v1.0
 */
public interface RolePermissionService {

    List<RolePermission> findAllByRole(Role role);

}
