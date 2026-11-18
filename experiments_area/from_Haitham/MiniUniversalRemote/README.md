# Mini Universal Remote

A small Java 17 project that simulates two household remotes: an LG TV and an
LG air-conditioner. Both share one abstract class, `RemoteCover`, so the programme
can use either remote through the same variable.

## Requirements

- JDK 17 or newer (`javac` and `java` on your `PATH`)

## Quick start

Run these commands from this folder (`experiments_area/from_Haitham/MiniUniversalRemote`):

```bash
# Compile
javac -d out *.java

# Run with the TV remote (default)
java -cp out Main

# Run with the AC remote
java -cp out Main AC
```

## Sample output

```
==== LG TV Remote ====
Buttons: Power, Channel Up, Channel Down
Device: LG TV | Power: OFF | Channel: 1
Turning ON...
Device: LG TV | Power: ON | Channel: 1
Counter Up -> 2
Device: LG TV | Power: ON | Channel: 2
Counter Down -> 1
Device: LG TV | Power: ON | Channel: 1
Turning OFF...
Device: LG TV | Power: OFF | Channel: 1
```

## Switching remotes in code

`Main` holds the remote through the abstract type, so changing one line is enough:

```java
RemoteCover remote = new LGTVRemote();   // change to new LGACRemote()
```

Recompile and the same calls drive the AC remote instead. No other code changes.

## Where the OOP ideas live

| Idea | Where to look |
|------|---------------|
| Abstraction | `RemoteCover` declares the six remote methods but implements none |
| Inheritance | `LGTVRemote` and `LGACRemote` both `extends RemoteCover` |
| Polymorphism | `Main` calls the methods through a `RemoteCover` variable, so the behaviour swaps with the object |
| Encapsulation | Each remote keeps its state (`powerOn`, `channel` / `temperature`) and helpers (`setPower()`) `private` |

## Files

| File | Purpose |
|------|---------|
| `RemoteCover.java` | Abstract base class with the six remote actions |
| `LGTVRemote.java` | TV remote: power, channel counter, fixed display |
| `LGACRemote.java` | AC remote: power, temperature counter, cooling mode |
| `Main.java` | Entry point; prints the full status after every action |
