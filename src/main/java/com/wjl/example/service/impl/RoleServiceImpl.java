package com.wjl.example.service.impl;

import com.wjl.example.model.entity.Role;
import com.wjl.example.repository.RoleRepository;
import com.wjl.example.service.intf.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: wjl
 * @date: 2021/12/31 15:51
 * @version: v1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository roleRepository;

    @Override
    public Role findRoleById(Long rid) {
        return roleRepository.findRoleById(rid);
    }

}
