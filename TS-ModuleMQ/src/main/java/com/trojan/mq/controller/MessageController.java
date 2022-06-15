package com.trojan.mq.controller;

import com.trojan.mq.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    public static final Logger
            logger = LoggerFactory.getLogger(MessageController.class);
    @Value("${mail.exchange:mail-exchange}")
    private String mailExchange;
    @Value("${mail.route.feedback:mail-route-feedback}")
    private String mailRouteFeedback;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("addMessage")
    public void addMessage() {
        String msgId=System.currentTimeMillis()+"test";
        rabbitTemplate.convertAndSend(mailExchange, mailRouteFeedback, "test", new CorrelationData(msgId));
        logger.info("消息已投递");
    }
}
