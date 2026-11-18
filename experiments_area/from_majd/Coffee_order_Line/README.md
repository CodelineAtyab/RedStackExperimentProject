# Coffee Order Line

A small Java command-line program that manages coffee orders in a first-in, first-out queue. Orders are kept in memory while the program is running.

## Requirements

- Java 17 or later

## Compile and run

From this directory, run:

```text
javac CoffeeOrder.java
java CoffeeOrder
```

## Commands

- `order <name>` — add a customer's name to the end of the line.
- `serve` — serve and remove the next customer in line. If the line is empty, the program reports that no one can be served.
- `exit` — leave the program.

Commands are case-sensitive. For example:

```text
>order Alex
Queue:[Alex]  | Waiting: 1

>order Sam
Queue:[Alex, Sam]  | Waiting: 2

>serve
Serving: Alex
Queue:[Sam]  | Waiting: 1

>exit
```
