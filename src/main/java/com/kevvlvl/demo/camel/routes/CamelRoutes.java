package com.kevvlvl.demo.camel.routes;

import com.kevvlvl.demo.camel.dto.ClientDto;
import com.kevvlvl.demo.camel.service.ClientServiceImpl;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class CamelRoutes extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true")
                .contextPath("/").port(8080)
                .apiContextPath("/api-doc")
                    .apiProperty("api.title", "Kevvlvl Demo API")
                    .apiProperty("api.version", "1.0.0")
                    .apiProperty("cors", "true");

        rest()
                .get("/health").to("direct:getHealth")
                .produces("application/json").get("/clients/{id}")
                    .description("Get Client by ID")
                    .param().name("id").type(RestParamType.path).description("Client ID").dataType("int").endParam()
                    .to("direct:getClientById")
                .consumes("application/json").produces("application/json").post("/clients")
                    .description("Create a client")
                    .param().name("clientDetails").type(RestParamType.body).description("Client Info in JSON").dataType("String").endParam()
                    .to("direct:postNewClient")
                .consumes("application/json").produces("application/json").put("/clients/{id}")
                    .description("Create a client")
                    .param().name("id").type(RestParamType.path).description("ID of Client to update").dataType("int").endParam()
                    .param().name("clientInfo").type(RestParamType.body).description("Client Info in JSON").dataType("String").endParam()
                    .to("direct:putClient");

        from("direct:getHealth")
                .log(LoggingLevel.INFO, "API getHealth")
                .transform()
                .simple("Hello There!");

        from("direct:postNewClient")
                .to("direct:clientJsonToPojo")
                .bean(ClientServiceImpl.class, "createClient(${body})")
                .log(LoggingLevel.INFO, "API postNewClient - Created Client with ID=${body}");

        from("direct:getClienbtById")
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
