package com.demo.camel.demo.routes;

import com.demo.camel.demo.service.UserService;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class SimpleRoute extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);

        rest()
                .get("/hello")
                .to("direct:hello");

        from("direct:hello")
                .log(LoggingLevel.INFO, "Hello Dude")
                .transform()
                .simple("Hello Dude");

        rest()
                .get("/get/{id}")
                .to("direct:getUser");

        from("direct:getUser")
                .log(LoggingLevel.INFO, "pre-bean process. Received http query string ${header.id}")
                .bean(new UserService(), "get(${header.id})")
                .log(LoggingLevel.INFO, "post-bean process. ${body}")
                .end();

    }
}
