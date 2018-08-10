package br.com.conductor.retryexemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class RetryExemploApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetryExemploApplication.class, args);
    }
}
