package com.kevvlvl.demo.camel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoCamelApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCamelApplication.class, args);
    }
}
