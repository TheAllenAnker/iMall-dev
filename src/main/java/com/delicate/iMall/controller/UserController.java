package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.User;
import com.delicate.iMall.service.UserService;
import com.delicate.iMall.utils.JSONResult;
import com.delicate.iMall.utils.MD5Utils;
import com.delicate.iMall.utils.idworker.Sid;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @PostMapping("/login")
    public JSONResult login(@RequestBody User inUser) throws Exception {
        String username = inUser.getUsername();
        String password = inUser.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return JSONResult.errorMsg("用户名或密码不能为空");
        } else {
            User user = userService.findUserByUsername(username);
            if (user != null) {
                String encodeStr = password + user.getSalt();
                if (MD5Utils.getMD5Str(encodeStr).equals(user.getPassword())) {
                    user.setPassword("");
                    return JSONResult.ok(user);
                } else {
                    return JSONResult.errorMsg("用户名或密码错误");
                }
            } else {
                return JSONResult.errorMsg("用户名或密码错误");
            }
        }
    }

    @PostMapping("/register")
    public JSONResult register(@RequestBody User inUser) throws Exception {
        String username = inUser.getUsername();
        String password = inUser.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return JSONResult.errorMsg("用户名或密码不能为空");
        } else {
            User user = userService.findUserByUsername(username);
            if (user == null) {
                user = new User();
                String salt = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
                password = MD5Utils.getMD5Str(password + salt);
                user.setUsername(username);
                user.setPassword(password);
                user.setAvatar(inUser.getAvatar());
                user.setEmail("");
                user.setGender(0);
                user.setNickname(inUser.getNickname());
                user.setSalt(salt);
                user.setStatus(0);
                user.setPhone("");
                user.setId(sid.nextShort());
                userService.saveUser(user);
                return JSONResult.ok(user);
            } else {
                return JSONResult.errorMsg("用户名已存在，换个用户名试试？");
            }
        }
    }

    @PostMapping("/deleteUser")
    public JSONResult deleteUser(String userId) {
        userService.deleteUserById(userId);
        return JSONResult.ok();
    }

    @PostMapping("/updateUseInfo")
    public JSONResult updateUserInfo(String infoJSONString) {
        User user = JSONObject.parseObject(infoJSONString, User.class);
        userService.updateUserInfo(user);
        return JSONResult.ok(user);
    }

    @RequestMapping("/query")
    public JSONResult queryUserInfo(String userId) {
        User user = userService.findUserById(userId);
        return JSONResult.ok(user);
    }
}
