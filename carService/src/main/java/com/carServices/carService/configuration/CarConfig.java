package com.carServices.carService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CarConfig {
    @Bean
    public String carBean()
    {
        return "Cars";
    }
}
