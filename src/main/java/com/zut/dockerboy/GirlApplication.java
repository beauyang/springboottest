package com.zut.dockerboy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class GirlApplication {
    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class,args);
    }
}
