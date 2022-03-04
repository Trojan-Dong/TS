package com.trojan.two.receiver;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailExchangeReceiver {

    private static final Logger logger = LoggerFactory.getLogger(MailExchangeReceiver.class);

    @RabbitListener(queues = "${mail.queue.feedback:mail-queue-feedback}")
    public void getReceiveMessage(Message message, Channel channel) throws IOException {
        logger.info("message:{}", message.getPayload().toString());
        MessageHeaders headers = message.getHeaders();
        long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        logger.info("tag{}", tag);
        channel.basicAck(tag, true);
    }
}
