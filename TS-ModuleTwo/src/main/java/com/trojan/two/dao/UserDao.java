package com.trojan.two.dao;

import com.trojan.one.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    public List<User> getAllUser();

    /**
     * 测试dao方法重载
     *
     * @param id
     * @return
     */
    public List<User> getAllUser(@Param("id") int id);
}
