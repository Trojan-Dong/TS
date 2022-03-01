package com.trojan.two.controller;

import com.trojan.one.entity.RespBean;
import com.trojan.one.entity.User;
import com.trojan.two.service.UserService;
import com.trojan.two.test.event.DemoEventOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("one")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    ApplicationContext context;
    @Autowired
    UserService userService;

    @RequestMapping("test")
    public RespBean printInfo(@RequestBody @Valid User user) {
        context.publishEvent(new DemoEventOne(this, "msg"));

//        DataSourceTransactionManager transactionManager=new DataSourceTransactionManager();
//        transactionManager.getTransaction(TransactionDefinition.PROPAGATION_REQUIRED );
        List<User> list = userService.getAllUser(user.getId());
        for (User temp : list) {
            logger.info("id:{},name:{}", temp.getId(), temp.getUsername());
        }
        return RespBean.ok("Test请求成功");
    }
}
