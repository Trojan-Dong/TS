package com.trojan.two.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printOne() {
        System.out.println("one" + System.currentTimeMillis());
    }
}
