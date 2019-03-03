package com.delicate.iMall.service;

import com.delicate.iMall.bean.User;

import java.util.List;

public interface UserService {
    User findUserById(String userId);

    User findUserByUsername(String username);

    void updateUserInfo(User user);

    void saveUser(User user);

    void deleteUserById(String userId);
}
