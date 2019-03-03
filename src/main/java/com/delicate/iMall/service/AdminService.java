package com.delicate.iMall.service;

import com.delicate.iMall.bean.Admin;

public interface AdminService {
    Admin findAdminById(String adminId);

    Admin findAdminByUsername(String username);

    void addAdmin(Admin admin);

    void deleteAdmin(Admin admin);

    void updateAdminInfo(Admin admin);
}
