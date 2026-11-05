# Support Center Ticket Queue

A Java console program that manages support tickets in a waiting queue. Regular tickets are added to the end of the queue, while urgent tickets are placed at the front. Tickets are served in queue order.

## Features

- Add a regular ticket.
- Add an urgent ticket ahead of all tickets currently waiting.
- Serve the next ticket.
- Display all waiting tickets.
- Report when the queue is empty.

## Run

From this directory, compile and run the program:

```sh
javac supportCenterTicket.java
java supportCenterTicket
```

At startup, enter the number of menu actions to perform. For each action, choose an option:

1. Add Ticket
2. Add urgent Ticket
3. Serve next Ticket
4. View waiting Tickets

Enter ticket descriptions when prompted. An invalid menu choice displays an error message and still counts as one of the requested actions.
