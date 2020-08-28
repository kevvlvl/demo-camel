package com.kevvlvl.demo.camel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScans({
        @ComponentScan("com.kevvlvl.demo.camel.routes"),
        @ComponentScan("com.kevvlvl.demo.camel.service"),
})
@EnableJpaRepositories("com.kevvlvl.demo.camel.repository")
public class SpringConfig {

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
