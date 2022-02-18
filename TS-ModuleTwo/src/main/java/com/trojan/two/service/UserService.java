package com.trojan.two.service;

import com.trojan.one.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();

    public List<User> getAllUser(int id);
}
