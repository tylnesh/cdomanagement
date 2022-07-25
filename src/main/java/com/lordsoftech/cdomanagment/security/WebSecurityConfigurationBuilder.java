package com.lordsoftech.cdomanagment.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WebSecurityConfigurationBuilder {
    private UserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfigurationBuilder setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        return this;
    }

    public WebSecurityConfigurationBuilder setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        return this;
    }

    public WebSecurityConfiguration createWebSecurityConfiguration() {
        return new WebSecurityConfiguration(userDetailsService, bCryptPasswordEncoder);
    }
}