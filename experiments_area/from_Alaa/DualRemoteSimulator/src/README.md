# Dual-Remote Simulator

A Java 17 Maven project that simulates two household remote controls: an LG TV remote and an LG Air Conditioner remote.

The project demonstrates the four main Object-Oriented Programming (OOP) principles: Encapsulation, Abstraction, Inheritance, and Polymorphism.

## Project Structure

```text
DualRemoteSimulator/
│
└── src/
    ├── remotes/
    │   ├── RemoteCover.java
    │   ├── LGTVRemote.java
    │   └── LGACRemote.java
    │
    ├── Main.java
    └── README.md
```

## Requirements

- Java 17 or later
- Apache Maven
- IntelliJ IDEA (optional)

## Remote Controls

### LG TV Remote
- Controls TV power (ON/OFF).
- Increases and decreases the channel.
- Maintains a fixed volume of 15.

### LG AC Remote
- Controls AC power (ON/OFF).
- Increases and decreases the temperature.
- Supports temperatures between 16°C and 30°C.
- Uses COOL mode.

## Build and Run

Compile the project:

```bash
mvn clean compile
```

Run the application:

```bash
mvn exec:java
```

To select the remote, change the object assigned to the `RemoteCover` variable in `Main.java`.

For the TV:

```java
RemoteCover remote = new LGTVRemote();
```

For the AC:

```java
RemoteCover remote = new LGACRemote();
```

The remaining method calls stay unchanged.

## OOP Concepts Demonstrated

1. **Encapsulation:** Private fields and private helper methods protect the internal state and logic of each remote.
2. **Abstraction:** The abstract `RemoteCover` class defines the common methods that every remote must implement.
3. **Inheritance:** `LGTVRemote` and `LGACRemote` extend `RemoteCover` and implement its abstract methods.
4. **Polymorphism:** A `RemoteCover` reference can point to either concrete remote, allowing the same method calls to produce different behaviours.

## Technologies

- Java 17
- Apache Maven