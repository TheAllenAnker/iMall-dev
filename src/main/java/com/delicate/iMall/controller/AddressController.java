package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.AddressItemVO;
import com.delicate.iMall.bean.User;
import com.delicate.iMall.bean.UserAddress;
import com.delicate.iMall.service.UserAddressService;
import com.delicate.iMall.service.UserService;
import com.delicate.iMall.utils.JSONResult;
import com.delicate.iMall.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @PostMapping(path = "/getAddressVOByAddressId")
    public JSONResult getAddressVOByAddressId(String addressId) {
        UserAddress address = userAddressService.getAddressByAddressId(addressId);
        User user = userService.findUserById(address.getUserId());
        AddressItemVO addressItemVO = new AddressItemVO();
        addressItemVO.setAddressId(addressId);
        addressItemVO.setAddress(address.getAddress());
        addressItemVO.setPhone(user.getPhone());
        addressItemVO.setUsername(user.getNickname());

        return JSONResult.ok(JSONObject.toJSONString(addressItemVO));
    }

    @PostMapping(path = "/getAddressesByUserId")
    public JSONResult getUserAddresses(String userId) {
        List<UserAddress> userAddresses = userAddressService.getAddressesByUserId(userId);
        List<AddressItemVO> addressItemVOs = new ArrayList<>();
        User user = userService.findUserById(userId);
        for (UserAddress userAddress : userAddresses) {
            AddressItemVO addressItemVO = new AddressItemVO();
            addressItemVO.setAddressId(userAddress.getId());
            addressItemVO.setAddress(userAddress.getAddress());
            addressItemVO.setUsername(user.getNickname());
            addressItemVO.setPhone(user.getPhone());
            addressItemVOs.add(addressItemVO);
        }

        return JSONResult.ok(JSONObject.toJSONString(addressItemVOs));
    }

    @PostMapping(path = "/addAddress")
    public JSONResult addAddress(String userId, String address) {
        UserAddress userAddress = new UserAddress();

        userAddress.setId(sid.nextShort().substring(0, 8));
        userAddress.setUserId(userId);
        userAddress.setAddress(address);
        userAddress.setStatus(0);

        userAddressService.addAddress(userAddress);
        return JSONResult.ok();
    }

    @PostMapping(path = "/deleteAddressById")
    public JSONResult deleteAddressById(String addressId) {
        userAddressService.deleteAddressById(addressId);
        return JSONResult.ok();
    }

    @PostMapping(path = "/updateAddressInfo")
    public JSONResult updateAddressInfo(@RequestBody UserAddress inUserAddress) {
        UserAddress userAddress = userAddressService.getAddressByAddressId(inUserAddress.getId());
        userAddress.setAddress(inUserAddress.getAddress());
        userAddressService.updateAddressInfo(userAddress);
        return JSONResult.ok();
    }
}
