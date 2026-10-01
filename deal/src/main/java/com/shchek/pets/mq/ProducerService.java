package com.shchek.pets.mq;

import com.rabbitmq.client.*;
import io.quarkiverse.rabbitmqclient.RabbitMQClient;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

public class ProducerService {
    private static final Logger log = LoggerFactory.getLogger(ProducerService.class);
    @Inject
    RabbitMQClient rabbitMQClient;
    private Channel channel;
    public void onApplicationStart(@Observes StartupEvent event) {
        setupQueues();
        send("START!");
    }

    private void setupQueues() {
        try {
            Connection connection = rabbitMQClient.connect();
            channel = connection.createChannel();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

//    private void setupReceiving() {
//        try {
//            // register a consumer for messages
//            channel.basicConsume("order.create.rq", false, new DefaultConsumer(channel) {
//                @Override
//                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                    // just print the received message.
//                    log.info("Received: " + new String(body, StandardCharsets.UTF_8));
//                }
//            });
//        } catch (IOException e) {
//            throw new UncheckedIOException(e);
//        }
//}

public void send(String message) {
    try {
        channel.basicPublish("delivery", "order.create.rq", null, message.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
}
}
