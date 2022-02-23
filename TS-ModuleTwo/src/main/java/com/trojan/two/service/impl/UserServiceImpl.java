package com.trojan.two.service.impl;

import com.trojan.one.entity.User;
import com.trojan.two.dao.UserDao;
import com.trojan.two.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
    @Override
    public List<User> getAllUser(int id) {
        return userDao.getAllUser(id);
    }
}
