# demo-camel

A simple spring-boot based project exposing rest endpoints using apache camel.
The purpose was for me to experiment camel's routing/DSL capabilities with simple to understand examples.

Endpoints:
- GET api/health for custom API health check
- POST api/clients to create a client
- GET api/clients/{clientId} to get a client
- PUT api/clients{clientId} to update a Client

Testing the endpoints:
- curl localhost:8080/api/health
- curl -X POST -H "Content-Type: application/json" localhost:8080/api/clients -d '{"firstName": "Austin", "lastName": "Powars"}'
- curl localhost:8080/api/clients/0 (Client ID)
- curl -X PUT -H "Content-Type: application/json" localhost:8080/api/clients/0 -d '{"firstName": "Austin", "lastName": "Powarzz"}'