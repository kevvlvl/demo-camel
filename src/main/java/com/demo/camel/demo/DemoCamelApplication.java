package com.demo.camel.demo;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.demo.camel.demo.routes")
public class DemoCamelApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCamelApplication.class, args);
    }

    /**
     * Default path is /camel/*
     * Change to /api/*
     * @return
     */
    @Bean
    public ServletRegistrationBean camelServletRegistrationBean() {
        ServletRegistrationBean reg = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/api/*");
        reg.setName("CamelServlet");
        return reg;
    }
}
