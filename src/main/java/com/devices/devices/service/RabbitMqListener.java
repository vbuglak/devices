package com.devices.devices.service;

import com.devices.devices.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

@Component
public class RabbitMqListener {
    Logger logger = Logger.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void processQueue1(String message) {
        logger.info("Received from orders-queue: " + message);
    }
}

