package com.alis.stockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.alis.stockservice.entity" })
@EnableJpaRepositories(basePackages = { "com.alis.stockservice.repo" })
@ComponentScan(basePackages = { "com.alis.stockservice" })
public class TestMain {

    public static void main(String[] args) {
            SpringApplication.run(TestMain.class, args);
        }
    }

