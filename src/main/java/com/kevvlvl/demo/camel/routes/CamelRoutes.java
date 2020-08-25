package com.kevvlvl.demo.camel.routes;

import com.kevvlvl.demo.camel.dto.ClientDto;
import com.kevvlvl.demo.camel.service.ClientServiceImpl;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class CamelRoutes extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration()
                .component("servlet");

        rest()
                .get("/health").to("direct:getHealth")
                .get("/clients/{id}").to("direct:getClientById")
                .consumes("application/json").produces("application/json").post("/clients").to("direct:postNewClient");

        from("direct:getHealth")
                .log(LoggingLevel.INFO, "API getHealth")
                .transform()
                .simple("Hello There!");

        from("direct:postNewClient")
                .unmarshal().json(JsonLibrary.Jackson, ClientDto.class)
                .bean(ClientServiceImpl.class, "createClient(${body})")
                .log(LoggingLevel.INFO, "Created Client with ID=${body}");

        from("direct:getClientById")
                .log(LoggingLevel.INFO, "API getClientById - Received query string=${header.id}")
                .bean(ClientServiceImpl.class, "getByClientId(${header.id})")
                .choice()
                    .when(body().isNull()).setBody(simple("Client not found"))
                    .otherwise().marshal().json(JsonLibrary.Jackson)
                .end();
    }
}
