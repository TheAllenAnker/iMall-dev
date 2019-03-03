package com.delicate.iMall.service.impl;

import com.delicate.iMall.bean.Admin;
import com.delicate.iMall.dao.AdminDao;
import com.delicate.iMall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findAdminById(String adminId) {
        return adminDao.findAdminById(adminId);
    }

    @Override
    public Admin findAdminByUsername(String username) {
        return adminDao.findAdminByUsername(username);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminDao.addAdmin(admin);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        adminDao.deleteAdmin(admin);
    }

    @Override
    public void updateAdminInfo(Admin admin) {
        adminDao.updateAdminInfo(admin);
    }
}
