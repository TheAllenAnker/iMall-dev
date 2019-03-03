package com.delicate.iMall.service.impl;

import com.delicate.iMall.bean.User;
import com.delicate.iMall.dao.UserDao;
import com.delicate.iMall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(String userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public void updateUserInfo(User user) {
        userDao.updateUserInfo(user);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUserById(String userId) {
        userDao.deleteUserById(userId);
    }
}
