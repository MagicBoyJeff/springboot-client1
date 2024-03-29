package com.hujie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootClient1Application {

    public static void main(String[] args) {
        SpringApplication.run( SpringbootClient1Application.class, args );
    }

}
