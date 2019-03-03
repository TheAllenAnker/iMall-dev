package com.delicate.iMall.service;

import com.delicate.iMall.bean.UserAddress;

import java.util.List;

public interface UserAddressService {
    List<UserAddress> getAddressesByUserId(String userId);

    void addAddress(UserAddress address);

    void deleteAddressById(String id);

    void updateAddressInfo(UserAddress userAddress);
}
