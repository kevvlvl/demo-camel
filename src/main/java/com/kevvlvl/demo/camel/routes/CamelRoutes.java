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
                .produces("application/json").get("/clients/{id}").to("direct:getClientById")
                .consumes("application/json").produces("application/json").post("/clients").to("direct:postNewClient")
                .consumes("application/json").produces("application/json").put("/clients/{id}").to("direct:putClient");

        from("direct:getHealth")
                .log(LoggingLevel.INFO, "API getHealth")
                .transform()
                .simple("Hello There!");

        from("direct:postNewClient")
                .to("direct:clientJsonToPojo")
                .bean(ClientServiceImpl.class, "createClient(${body})")
                .log(LoggingLevel.INFO, "API postNewClient - Created Client with ID=${body}");

        from("direct:getClientById")
                .log(LoggingLevel.INFO, "API getClientById - Received query string=${header.id}")
                .bean(ClientServiceImpl.class, "getByClientId(${header.id})")
                .choice()
                    .when(body().isNull()).setBody(simple("Client not found"))
                    .otherwise().to("direct:clientPojoToJson")
                .end();

        from("direct:putClient")
                .to("direct:clientJsonToPojo")
                .bean(ClientServiceImpl.class, "updateClient(${header.id}, ${body})")
                .log(LoggingLevel.INFO, "API putClient - Updated client with ID=${header.id}");

        // convert a JSON to POJO
        from("direct:clientJsonToPojo")
                .unmarshal().json(JsonLibrary.Jackson, ClientDto.class);

        // convert a POJO to JSON
        from("direct:clientPojoToJson")
                .marshal().json(JsonLibrary.Jackson);
    }
}
