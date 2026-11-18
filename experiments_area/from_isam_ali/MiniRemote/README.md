# Remote Control OOP Demo (Java 17+)

A self-contained Java project that demonstrates the four major OOP concepts
(Encapsulation, Abstraction, Inheritance and Polymorphism) through two concrete
remote controls: `LGTVRemote` and `LGACRemote`.

## Quick Start

Requires Java 17 or newer. Run these commands from the project root.

**Windows (Command Prompt / PowerShell)**

```
javac -d out src\*.java

java -cp out Main TV
java -cp out Main AC
```

**macOS / Linux**

```bash
# Compile
javac -d out $(find src -name "*.java")

# Run with TV remote
java -cp out Main TV

# Run with AC remote
java -cp out Main AC
```

If no argument is given, `Main` uses the TV remote.

## Project Layout

```
src/
  RemoteCover.java   abstract base class (the contract + shared state)
  LGTVRemote.java    channel counter + fixed volume
  LGACRemote.java    temperature counter + fixed cooling mode
  Main.java          client code, works only with RemoteCover
```

## Where to Find the OOP Concepts

| OOP Concept   | Where to look in the code | How it is shown |
|---------------|---------------------------|-----------------|
| Encapsulation | Private helpers in `LGTVRemote` (`powerToggle()`, `increaseChannel()`, `decreaseChannel()`) and `LGACRemote` (`powerToggle()`, `increaseTemperature()`, `decreaseTemperature()`) | Internal state and logic are hidden from other classes |
| Abstraction   | The `RemoteCover remote` variable in `Main.java`; the abstract methods in `RemoteCover.java` | Client code relies only on the abstract type |
| Inheritance   | `LGTVRemote` and `LGACRemote` both `extends RemoteCover` | Device name and power state are inherited from the abstract class |
| Polymorphism  | The single `RemoteCover remote = ...` line in `Main.java` | Same method calls, different runtime results |

### Abstract methods in `RemoteCover`

`getInfoFromScreen()`, `turnOn()`, `turnOff()`, `turnCounterUp()`,
`turnCounterDown()` and `placeButtons()` are declared but not implemented.
Both remotes provide their own complete implementation of each one.

## Switching Remotes

`Main.java` picks the remote on one line:

```java
RemoteCover remote = choice.equalsIgnoreCase("AC") ? new LGACRemote() : new LGTVRemote();
```

You can also hard-code it by replacing that line with:

```java
RemoteCover remote = new LGTVRemote(); // or new LGACRemote();
```

No other code changes are needed. Recompile and the behaviour adapts.

## Example Console Sessions

`java -cp out Main TV`

```
==== LG TV Remote ====
Power: OFF | Channel: 1
Turning ON...
Power: ON  | Channel: 1
Channel Up -> 2
Channel Down -> 1
Turning OFF...
Power: OFF | Channel: 1
```

`java -cp out Main AC`

```
==== LG AC Remote ====
Power: OFF | Temperature: 24
Turning ON...
Power: ON  | Temperature: 24
Temperature Up -> 25
Temperature Down -> 24
Turning OFF...
Power: OFF | Temperature: 24
```

## Notes

- Counter buttons are ignored while the device is off, and a message says so.
- The TV channel counter runs from 1 to 99 and wraps around.
- The AC temperature runs from 16 to 30 and stops at the limits.
