package com.wjl.example.service.impl;

import com.wjl.example.model.entity.User;
import com.wjl.example.repository.UserRepository;
import com.wjl.example.service.intf.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: wjl
 * @date: 2021/12/31 15:52
 * @version: v1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

}
