package com.trojan.two;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.trojan.two.dao")
public class OneApp {
    public static void main(String[] args) {
//        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:one.xml");
//        OneService oneService=context.getBean(OneService.class);
//        oneService.printOne();
//        SpringBootApplication
        SpringApplication.run(OneApp.class, args);
//        context.getBean();

    }
}
