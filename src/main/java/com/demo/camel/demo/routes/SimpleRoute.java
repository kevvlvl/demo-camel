package com.demo.camel.demo.routes;

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
                .log(LoggingLevel.OFF, "Hello World")
                .transform()
                .simple("Hello world");
    }
}
