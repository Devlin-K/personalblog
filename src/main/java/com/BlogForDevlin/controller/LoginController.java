package com.BlogForDevlin.controller;

import com.BlogForDevlin.configuration.SecurityEncode;
import com.BlogForDevlin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @program: personalblog
 * @description: Login, Register, CheckOut, WeChat Login...function
 * @author: Devlin
 * @create: 2019-09-04 22:49
 **/
@Component
public class LoginController implements UserDetailsService {
    @Autowired
    private SecurityEncode passwordEncoder;

    private Logger logger= LoggerFactory.getLogger(LoginController.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("用户的用户名: {}", username);
        // TODO 根据用户名，查找到对应的密码，与权限\

        String password = passwordEncoder.passwordEncoder().encode("123456");
        logger.info("password: {}", password);

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        User user = new User(username, password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}
