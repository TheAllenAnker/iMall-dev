package com.delicate.iMall.dao;

import com.delicate.iMall.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> findAllUsers();
}
