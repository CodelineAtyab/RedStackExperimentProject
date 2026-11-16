# Support Center Ticket

A Java console application for managing a support desk's waiting tickets.

## Requirements

- Java Development Kit (JDK) 17 or later

## Run

Open a terminal in this directory and compile and run the program:

```sh
javac supportCenterTicket.java
java supportCenterTicket
```

## Use

At startup, enter how many menu actions you want to perform. For each action,
choose one of the following:

1. **Add Ticket** — add a ticket to the end of the waiting line.
2. **Add urgent Ticket** — add an urgent ticket to the front of the line, ahead
   of tickets already waiting.
3. **Serve next Ticket** — serve and remove the ticket at the front of the line.
4. **View waiting Tickets** — display tickets in their current serving order.

The program reports when there are no tickets to serve or view.
