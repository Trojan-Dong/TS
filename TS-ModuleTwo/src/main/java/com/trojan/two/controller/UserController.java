package com.trojan.two.controller;

import com.trojan.one.entity.RespBean;
import com.trojan.one.entity.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("test")
    public RespBean printInfo(@RequestBody @Valid User user) {
        System.out.println(user.getId());
        System.out.println(user.getName());
        return RespBean.ok("Test请求成功");
    }
}
