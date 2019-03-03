package com.delicate.iMall.service.impl;

import com.delicate.iMall.bean.User;
import com.delicate.iMall.dao.UserDao;
import com.delicate.iMall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
}
