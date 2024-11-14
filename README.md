# Jestr Axon Demo

## Setup 

Create an application in the AxonIQ Cloud console.

https://console.cloud.axoniq.io/

Set the following values in application.properties:

* axon.axonserver.context
* axon.axonserver.token

## Run Demo

```
cd jestr-axon-demo
./gradlew bootRun
```

Note that, this demo does not use commands or aggregates which have certain complexities and issues.
It includes an in-memory database that does not persist projected data.
However, because it has not been configured to remember where it is in the axon event stream,
previous events are replayed when the connection tot he axon server is established so the data is restored.

## Sample Requests

### Create a joke
```
curl -i -X POST -H 'Content-Type: application/json' -d '{"contributor":"leopardpig", "setup":"Why did the chicken cross the road.","punchline":"To get to the other side."}' http://localhost:8080/jokes

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 13 Nov 2024 18:14:31 GMT

{"jokeId":"77a9367a-6edc-4b0d-ac93-d3031ddd1a10"}
```

Generates the following events in the AxonIQ Cloud Console:

- JokeCreateRequested
- JokeCreated

### Retrieve a joke
```
curl -i -X GET http://localhost:8080/jokes/77a9367a-6edc-4b0d-ac93-d3031ddd1a10
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 13 Nov 2024 18:16:21 GMT

{"id":"77a9367a-6edc-4b0d-ac93-d3031ddd1a10","contributor":"leopardpig","setup":"Why did the chicken cross the road.","punchline":"To get to the other side.","owner":null,"status":"SUBMITTED","statusTime":"2024-11-13T11:14:31.510659","submitTime":"2024-11-13T11:14:31.510659"
```

### Create another joke

```
curl -i -X POST -H 'Content-Type: application/json' -d '{"contributor":"funkymonkey", "setup":"Why did the hipster burn his mouth.","punchline":"Because he sipped his coffee before it was cool."}' http://localhost:8080/jokes

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 13 Nov 2024 18:24:05 GMT

{"jokeId":"0393bdff-7534-4809-b71e-b68da1dfbbb4"}
```

Generates the following events in the AxonIQ Cloud Console:

- JokeCreateRequested
- JokeCreated

### Assign a joke

```
curl -i -X POST -H 'Content-Type: application/json' -d '{"username":"funkymonkey"}' http://localhost:8080/jokes/77a9367a-6edc-4b0d-ac93-d3031ddd1a10/assignments

HTTP/1.1 204
Date: Wed, 13 Nov 2024 18:28:17 GMT
```

Generates the following events in the AxonIQ Cloud Console:

- JokeAssignmentRequested
- JokeAssigned

### Retrieve assigned joke

```
curl -i -X GET http://localhost:8080/jokes/77a9367a-6edc-4b0d-ac93-d3031ddd1a10
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 13 Nov 2024 18:29:13 GMT

{"id":"77a9367a-6edc-4b0d-ac93-d3031ddd1a10","contributor":"leopardpig","setup":"Why did the chicken cross the road.","punchline":"To get to the other side.","owner":"funkymonkey","status":"ASSIGNED","statusTime":"2024-11-13T11:28:17.851339","submitTime":"2024-11-13T11:21:55.134685"}%
```

### Assign already assigned joke
```
curl -i -X POST -H 'Content-Type: application/json' -d '{"username":"lucygoosie"}' http://localhost:8080/jokes/77a9367a-6edc-4b0d-ac93-d3031ddd1a10/assignments
  
HTTP/1.1 204
Date: Wed, 13 Nov 2024 18:28:17 GMT
```

Generates the following events in the AxonIQ Cloud Console:

- JokeAssignmentRequest

### Delete joke
```
curl -i -X DELETE http://localhost:8080/jokes/77a9367a-6edc-4b0d-ac93-d3031ddd1a10
HTTP/1.1 204
Date: Wed, 13 Nov 2024 18:35:17 GMT
```

Generates the following events in the AxonIQ Cloud Console:

- JokeDeletionRequested
- JokeDeleted

### Retrieve deleted joke
```
curl -i -X GET http://localhost:8080/jokes/77a9367a-6edc-4b0d-ac93-d3031ddd1a10
HTTP/1.1 404
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 13 Nov 2024 18:35:29 GMT

[{"message":"joke not found"}]
```
