package dev.adimallik.runnerz;

import org.springframework.stereotype.Component;

// this tells Spring Boot that this class is available to the ApplicationContainer
@Component
public class WelcomeMessage {
    public String getWelcomeMessage(){
        return "Welcome to Spring Boot!";
    }
}
