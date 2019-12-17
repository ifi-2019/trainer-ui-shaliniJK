package com.ifi.trainer_ui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @Value("${trainer.service.username}")
    private String username;

    @Value("${trainer.service.password}")
    private String password;

    @Autowired
    public RestConfiguration() {}

    @Bean
    RestTemplate trainerApiRestTemplate(){
        RestTemplate template = new RestTemplate();

        template.getInterceptors().add( new BasicAuthenticationInterceptor("username", "password") );

        return template;
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
