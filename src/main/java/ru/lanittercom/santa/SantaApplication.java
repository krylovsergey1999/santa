package ru.lanittercom.santa;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class SantaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SantaApplication.class, args);
    }

}
