package com.delicate.iMall.dao;

import com.delicate.iMall.bean.UserAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressDao {
    List<UserAddress> getAddressesByUserId(String userId);

    void addAddress(UserAddress address);

    void deleteAddressById(String id);

    void updateAddressInfo(UserAddress userAddress);
}
