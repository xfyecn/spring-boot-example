package com.wjl.example.service.impl;

import com.wjl.example.model.entity.Role;
import com.wjl.example.model.entity.RolePermission;
import com.wjl.example.repository.RolePermissionRepository;
import com.wjl.example.service.intf.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wjl
 * @date: 2021/12/31 15:50
 * @version: v1.0
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Resource
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public List<RolePermission> findAllByRole(Role role) {
        return rolePermissionRepository.findAllByRid(role.getId());
    }

}
