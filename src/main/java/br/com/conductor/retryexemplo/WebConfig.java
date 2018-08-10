package br.com.conductor.retryexemplo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WebConfig {

    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
