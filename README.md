## Note Taking Application

To run:
```
    cd NoteTakingRESTServer/
    ./gradlew build && java -jar ./build/libs/note-taking-rest-server-0.1.0.jar
```

Note: You will need mongodb installed and running with default configuration.

### Add note
```
    curl -i -H "Content-Type:application/json" -X POST -d '{"body" : "Pick up milk!"}' http://localhost/api/notes
```

### Get an Existing Note
```
    curl -i -H "Accept: application/json" -X GET http://localhost/api/notes/5577a34903641468f1e2f115
```

### Get All of Notes
```
    curl -i -H "Accept: application/json" -X GET http://localhost/api/notes
```
or
```
    curl -i -H "Accept: application/json" -X GET http://localhost/api/notes?query=forget
```
