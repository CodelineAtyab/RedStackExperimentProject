# Café Order-Line Simulator

## Description

A Java console application that simulates a café customer queue using the Queue data structure.

The application follows the FIFO (First In, First Out) principle. The first customer who joins the queue is the first customer served.

## Features

- Add customers using the `order` command.
- Serve customers using the `serve` command.
- Display the current queue.
- Display the number of waiting customers.
- Handle an empty queue.
- Reject null and blank customer names.

## Technologies

- Java 17
- Maven
- JUnit 5
- Queue interface
- LinkedList implementation

## Commands

| Command | Description |
|---|---|
| `order Alice` | Adds Alice to the queue |
| `serve` | Serves the first customer |
| `exit` | Exits the application |

## Testing

Run the unit tests with:

```bash
mvn test
```

Five JUnit tests cover customer insertion, FIFO order, empty queues, invalid names, and waiting-count updates.

## Project Structure

```text
CafeOrderQueue/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       └── CafeOrderQueue.java
    └── test/
        └── java/
            └── CafeOrderQueueTest.java
```
