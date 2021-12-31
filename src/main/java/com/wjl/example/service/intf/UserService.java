package com.wjl.example.service.intf;

import com.wjl.example.model.entity.User;

/**
 * @author: wjl
 * @date: 2021/12/31 15:49
 * @version: v1.0
 */
public interface UserService {

    User findUserById(Long id);

    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);

}
