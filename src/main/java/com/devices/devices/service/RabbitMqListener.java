package com.devices.devices.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.devices.devices.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RabbitMqListener {
    private static final Logger logger = LogManager.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void processQueue1(String message) {
        logger.info("Received from orders-queue: " + message);
    }
}

