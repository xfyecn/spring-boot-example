package com.wjl.example.service.impl;

import com.wjl.example.model.entity.User;
import com.wjl.example.model.entity.UserRole;
import com.wjl.example.repository.UserRoleRepository;
import com.wjl.example.service.intf.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wjl
 * @date: 2021/12/31 15:51
 * @version: v1.0
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findRolesByUser(User user) {
        return userRoleRepository.findAllByUid(user.getId());
    }

}
