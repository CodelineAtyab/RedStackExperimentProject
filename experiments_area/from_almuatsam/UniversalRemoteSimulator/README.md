# Universal Remote Simulator

## Overview

The Universal Remote Simulator is a Java project that demonstrates Object-Oriented Programming concepts through two simulated remote controls.

The project includes:
- LG TV Remote
- LG Air Conditioner Remote

Both remotes share an abstract parent class called `RemoteCover`.

## Features

### LG TV Remote
- Turns the TV on and off.
- Increases and decreases the channel.
- Prevents the channel from going below 1.
- Uses a fixed volume value.

### LG AC Remote
- Turns the air conditioner on and off.
- Increases and decreases the temperature.
- Keeps the temperature between 16°C and 30°C.
- Displays the cooling mode.

### Shared Features
- Displays device status.
- Prints a remote button layout.
- Uses the same abstract parent class for both devices.

## OOP Concepts Demonstrated

### 1. Encapsulation
- Fields in both remote classes are private.
- Private helper methods handle internal logic.
- Each remote controls its own state.

### 2. Abstraction
- `RemoteCover` is an abstract class.
- It declares six abstract methods.
- It defines the common structure for both remotes.

### 3. Inheritance
- `LGTVRemote` extends `RemoteCover`.
- `LGACRemote` extends `RemoteCover`.
- Both classes implement the abstract methods.

### 4. Polymorphism
- `Main` uses a `RemoteCover` reference.
- The reference can hold an `LGTVRemote` or an `LGACRemote` object.
- Java calls the correct implementation at runtime.

## Project Structure

```text
UniversalRemoteSimulator/
│
├── src/
│   ├── Main.java
│   ├── RemoteCover.java
│   ├── LGTVRemote.java
│   └── LGACRemote.java
│
└── README.md
```

## Requirements

- Java JDK 17 or later.

## How to Compile

From the project root directory, run:

```bash
javac -d out src/*.java
```

## How to Run

Run the TV remote:

```bash
java -cp out Main TV
```

Run the AC remote:

```bash
java -cp out Main AC
```

## Testing

The project was tested with both remote controls.

- TV channel minimum: 1.
- AC temperature minimum: 16°C.
- AC temperature maximum: 30°C.
- Power on and off operations.
- Runtime polymorphism through the `RemoteCover` reference.

## Author

Almuatasam

