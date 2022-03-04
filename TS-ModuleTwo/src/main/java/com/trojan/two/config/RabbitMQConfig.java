package com.trojan.two.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建并注入对应的交换器exchange和routingKey、queue
 * 并通过 BingingBuilder 进行绑定
 * 创建exchange时 druable 和autoDelete
 */
@Configuration
public class RabbitMQConfig {
    public static final Logger
            logger = LoggerFactory.getLogger(RabbitMQConfig.class);

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;
    @Value("${mail.exchange:mail-exchange}")
    private String mailExchange;
    @Value("${mail.route.feedback:mail-route-feedback}")
    private String mailRouteFeedback;
    @Value("${mail.queue.feedback:mail-queue-feedback}")
    private String mailQueueFeedback;

    @Bean
    DirectExchange mailExchange() {//获取一个交换器对象
        logger.info("mailExchange 注入");
        return new DirectExchange(mailExchange, true, true);
    }

    @Bean
    Queue mailQueue() {//创建一个队列
        return new Queue(mailQueueFeedback, true);
    }

    @Bean
    Binding mailQueueToMailExchange() {//通过exchange和routingKey 与queue进行绑定
        return BindingBuilder.bind(mailQueue()).to(mailExchange()).with(mailRouteFeedback);
    }
}
