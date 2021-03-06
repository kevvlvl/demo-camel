# demo-camel

A simple spring-boot based project exposing rest endpoints using apache camel.
The purpose was for me to experiment camel's routing/DSL capabilities with simple to understand examples.

This sample demo makes use of various librairies:
- Spring boot
- Apache camel with swagger
- Hibernate with H2 embedded database

by kevvlvl

## Endpoints

### H2 Database Console

* Open in browser http://localhost:8090/h2-console/

### Swagger API

* curl http://localhost:8090/api/api-doc/swagger.json
* curl http://localhost:8090/api/api-doc/swagger.yaml

### Actuator

* curl http://localhost:8090/actuator/health returns the health status of the app
* curl http://localhost:8090/actuator/loggers returns the loggers which you can manage (changing their log level)

### API
- GET api/health for custom API health check
  - Ex: curl localhost:8090/api/health
- POST api/clients to create a client
  - Ex: curl -X POST -H "Content-Type: application/json" localhost:8090/api/clients -d '{"firstName": "Austin", "lastName": "Powars"}'
- GET api/clients/{clientId} to get a client
  - Ex: curl localhost:8090/api/clients/0 (Client ID)
- PUT api/clients{clientId} to update a Client
  - Ex: curl -X PUT -H "Content-Type: application/json" localhost:8090/api/clients/0 -d '{"firstName": "Austin", "lastName": "Powarzz"}'
- POST api/client-tasks to create a client task
  - Ex: curl -X POST -H "Content-Type: application/json" localhost:8090/api/client-tasks -d '{"taskDescription": "Run batch job once a day", "clientId": "1"}'
- GET api/client-tasks/{clientId} to obtain list of client tasks
  - Ex:  curl -X GET -H "Content-Type: application/json" localhost:8090/api/client-tasks?clientId=1