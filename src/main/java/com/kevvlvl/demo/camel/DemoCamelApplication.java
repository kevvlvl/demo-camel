package com.kevvlvl.demo.camel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScans({
        @ComponentScan("com.kevvlvl.demo.camel.routes"),
        @ComponentScan("com.kevvlvl.demo.camel.service")
})
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
