package com.delicate.iMall.dao;

import com.delicate.iMall.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User findUserById(String userId);

    User findUserByUsername(String username);

    void updateUserInfo(User user);

    void saveUser(User user);

    void deleteUserById(String userId);
}
