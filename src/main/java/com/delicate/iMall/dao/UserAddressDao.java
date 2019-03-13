package com.delicate.iMall.dao;

import com.delicate.iMall.bean.UserAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressDao {
    UserAddress getAddressByAddressId(@Param("addressId") String addressId);

    List<UserAddress> getAddressesByUserId(@Param("userId")String userId);

    void addAddress(@Param("address") UserAddress address);

    void deleteAddressById(@Param("id") String id);

    void updateAddressInfo(UserAddress userAddress);
}
