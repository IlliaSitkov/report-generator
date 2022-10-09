package com.example.reportgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReportGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportGeneratorApplication.class, args);
    }

}
