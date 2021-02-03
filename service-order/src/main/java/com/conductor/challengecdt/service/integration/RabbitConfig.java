package com.conductor.challengecdt.service.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class RabbitConfig {
    private static Long EXPIRATION = 1l;

    @Bean
    public RabbitTemplate rabbitTemplate (ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setBeforePublishPostProcessors(eventMessagePostProcessor());

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println ("ConfirmCallback:" + "Dados relevantes:" + correlationData);
            System.out.println ("ConfirmCallback:" + "Confirmação:" + ack);
            System.out.println ("ConfirmCallback:" + "motivo:" + cause);
        });


        rabbitTemplate.setReturnsCallback( (returnedMessage)-> {
            System.out.println("Message:"+returnedMessage.getMessage());
            System.out.println("Response code:"+returnedMessage.getReplyCode());
            System.out.println("Response information:"+returnedMessage.getReplyText());
            System.out.println("Switch:"+returnedMessage.getExchange());
            System.out.println("Routing key:"+returnedMessage.getRoutingKey());
        });


        return rabbitTemplate;

    }

    public MessagePostProcessor eventMessagePostProcessor(){
        return message -> {
            long expiration = TimeUnit.HOURS.toMillis(EXPIRATION);
            message.getMessageProperties().setExpiration(String.valueOf(expiration));
            message.getMessageProperties().setContentType(MessageProperties.CONTENT_TYPE_JSON);
            return message;
        };
    }
}
