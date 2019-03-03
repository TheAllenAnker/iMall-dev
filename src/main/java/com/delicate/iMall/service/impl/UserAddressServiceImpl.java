package com.delicate.iMall.service.impl;

import com.delicate.iMall.bean.UserAddress;
import com.delicate.iMall.dao.UserAddressDao;
import com.delicate.iMall.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public List<UserAddress> getAddressesByUserId(String userId) {
        return userAddressDao.getAddressesByUserId(userId);
    }

    @Override
    public void addAddress(UserAddress address) {
        userAddressDao.addAddress(address);
    }

    @Override
    public void deleteAddressById(String id) {
        userAddressDao.deleteAddressById(id);
    }

    @Override
    public void updateAddressInfo(UserAddress userAddress) {
        userAddressDao.updateAddressInfo(userAddress);
    }
}
