package com.wjl.example.service.intf;

import com.wjl.example.model.entity.User;
import com.wjl.example.model.entity.UserRole;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/12/31 15:48
 * @version: v1.0
 */
public interface UserRoleService {

    List<UserRole> findRolesByUser(User user);

}
