# demo-camel

A simple spring-boot based project exposing rest endpoints using apache camel.
The purpose was for me to experiment camel's routing/DSL capabilities with simple to understand examples.

Endpoints:
- GET api/health
- POST api/clients
- GET api/clients/{clientId}

Testing the endpoints:
- curl localhost:8080/api/health
- curl -X POST -H "Content-Type: application/json" localhost:8080/api/clients -d '{"firstName": "Austin", "lastName": "Powars"}'
- curl localhost:8080/api/clients/0 (Client ID)