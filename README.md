# demo-camel

A simple spring-boot based project exposing rest endpoints using apache camel.
The purpose was for me to experiment camel's routing/DSL capabilities with simple to understand examples.

Endpoints:
- api/hello
- api/get/{userid}
- api/get/{userid}?getNumber=true 

Testing the endpoints:
- curl localhost:8080/api/hello
- curl localhost:8080/api/get/100
- curl localhost:8080/api/get/100?getNumber=true