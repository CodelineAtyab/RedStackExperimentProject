# Pair JSON Exchange - #522

Java 17, Spring Boot server and Unirest client.

## Server

In PairJsonServer:

```powershell
mvn clean test-compile
mvn spring-boot:run
```

Keep the server terminal open. View:
http://localhost:8080/profile?name=Sara

## Client

In a second terminal, inside PairJsonClient:

```powershell
mvn clean test-compile
mvn -q exec:java
```

To use a partner's real server address and a different name:

```powershell
mvn -q exec:java "-Dexec.args=http://192.168.1.20:8080 Abdullah"
```

The address above is an example. localhost means the client's own computer.
The two computers must be able to reach the server's port.

See NOTES.md and TEST_RESULTS.md. Partner testing remains pending.
