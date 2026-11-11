# Mini Universal Remote Simulator

A small Java example of a shared remote-control abstraction with LG TV and AC remote implementations.

## Files

- `RemoteCover.java` defines the common remote operations.
- `LGTVRemote.java` and `LGACRemote.java` implement the remote controls, including power toggling, channel counting, and screen information.
- `RemoteCoverMain.java` demonstrates using the abstraction with an `LGACRemote`.

## Requirements

Java 15 or later.

## Compile and run

From this directory, compile the source files and run the demo:

```text
javac RemoteCover.java LGTVRemote.java LGACRemote.java RemoteCoverMain.java
java RemoteCoverMain
```

# Compile
javac -d out $(find src -name "*.java")

# Run with TV remote
java -cp out Main TV

# Run with AC remote
java -cp out Main AC



The demo increments the channel twice and prints the remote's screen information.
