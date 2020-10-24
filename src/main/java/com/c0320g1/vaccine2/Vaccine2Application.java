package com.c0320g1.vaccine2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Vaccine2Application {

    public static void main(String[] args) {
        SpringApplication.run(Vaccine2Application.class, args);
    }

}
