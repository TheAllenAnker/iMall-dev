package com.delicate.iMall.dao;

import com.delicate.iMall.bean.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    Admin findAdminById(String adminId);

    Admin findAdminByUsername(String username);

    void addAdmin(Admin admin);

    void deleteAdmin(Admin admin);

    void updateAdminInfo(Admin admin);
}
