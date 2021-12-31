package com.wjl.example.service.impl;

import com.wjl.example.model.entity.Permission;
import com.wjl.example.repository.PermissionRepository;
import com.wjl.example.service.intf.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: wjl
 * @date: 2021/12/31 15:49
 * @version: v1.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionRepository permissionRepository;

    @Override
    public Permission findPermissionById(Long pid) {
        return permissionRepository.findPermissionById(pid);
    }

}
