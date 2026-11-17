# Local checks for #522 - 17 November 2026

Both projects passed mvn clean test-compile with Java 17.

ProfileClient against localhost:8080 returned:

```text
Name: Sara
1 - Coffee
2 - Books
3 - Football
```

Changing the name argument printed Name: Abdullah.

A temporary copy of the server on localhost:8081 changed Coffee to Tea.
The same client returned:

```text
Name: Abdullah
1 - Tea
2 - Books
3 - Football
```

Connecting to localhost:65534 printed:

```text
Could not reach the server. Check its address and port.
```

No second-computer partner round has been completed. These are local checks only.
