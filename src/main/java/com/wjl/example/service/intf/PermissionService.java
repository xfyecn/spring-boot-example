package com.wjl.example.service.intf;

import com.wjl.example.model.entity.Permission;

/**
 * @author: wjl
 * @date: 2021/12/31 15:47
 * @version: v1.0
 */
public interface PermissionService {

    Permission findPermissionById(Long pid);

}
