package com.delicate.iMall.service.security;

import com.delicate.iMall.bean.Admin;
import com.delicate.iMall.bean.AdminPrincipal;
import com.delicate.iMall.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDetailsService implements UserDetailsService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminDao.findAdminByUsername(username);
        if (admin != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new AdminPrincipal(admin.getUsername(), admin.getPassword(), authorities);
        }

        throw new UsernameNotFoundException("User " + username + " not found");
    }
}
