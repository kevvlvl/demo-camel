package com.kevvlvl.demo.camel.routes;

import com.kevvlvl.demo.camel.service.RandomGeneratorService;
import com.kevvlvl.demo.camel.service.UserService;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleRoute extends RouteBuilder {

    @Autowired
    private UserService userService;

    @Autowired
    private RandomGeneratorService randomGeneratorService;

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
                .get("/get/{id}?{getNumber}")
                .to("direct:getUser");

        from("direct:getUser")
                .log(LoggingLevel.INFO, "pre-bean process. Received http query string ${header.id}, ${header.getNumber}")
                .choice()
                    .when(header("getNumber").isEqualToIgnoreCase("true"))
                        .to("bean:userService?method=get(${header.id})").setHeader("user", simple("${body}"))
                        .to("bean:randomGeneratorService?method=getRandom()").setHeader("randomNumber", simple("${body}"))
                        .setBody(simple("${header.user} - ${header.randomNumber}"))
                    .otherwise()
                        .to("bean:userService?method=get(${header.id})").setHeader("user", simple("${body}"))
                .end()
                .log(LoggingLevel.INFO, "post-bean process. ${body}")
                .end();

    }
}
