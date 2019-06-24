package com.ford.featuretoggle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = { "com.ashwani.featuretoggle"})
@SpringBootApplication
public class FeaturetoggleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeaturetoggleApplication.class, args);
    }

}
