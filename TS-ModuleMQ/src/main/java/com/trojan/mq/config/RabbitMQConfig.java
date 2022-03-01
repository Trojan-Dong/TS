package com.trojan.mq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 自定义消息发送RabbitTemplate
 */
@Configuration
public class RabbitMQConfig {
    public static final Logger
            logger = LoggerFactory.getLogger(RabbitMQConfig.class);

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        //成功投递消息到Broker交换机站点的回调函数
        rabbitTemplate.setConfirmCallback((data, ack, cause) -> {
            String msgId = data.getId();
            if (ack) {
                logger.info(msgId + "消息发送成功");
            } else {
                logger.error(msgId + "消息发送失败！");
                logger.error(msgId + cause);
            }
        });
        //消息投递到Queue队列失败的回调函数
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returned) {
                logger.error(returned.getMessage().getBody() + "----消息从交换机投递到队列失败！\n错误原因：" + returned.getReplyText());
                logger.error("发送错误的交换机：" + returned.getExchange() + ",发生错误的路由key：" + returned.getRoutingKey());
            }
        });
        return rabbitTemplate;
    }
}
