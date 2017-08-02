package com.springessentialsbook.chapter4;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class ChatroomWebSocketMessageBrokerConfigurer extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        /*
            Specify /myApp as the prefix, and any client message whose destination starts with
            /myApp will be routed to the controller's message-handling methods.
         */
        config.setApplicationDestinationPrefixes("/myApp");
        /*
            Set the broker topic to /chatroomTopic. 
            Any messages whose destinations start with /chatroomTopic will be routed to 
            the message broker (that is, broadcasted to other connected clients).
        */
        config.enableSimpleBroker("/chatroomTopic");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/broadcastMyMessage").withSockJS();
    }
}
