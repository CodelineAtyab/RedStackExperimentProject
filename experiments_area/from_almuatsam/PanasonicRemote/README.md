# PanasonicRemote

A Java command-line program that simulates a Panasonic AC remote.

## Requirements

- **JDK:** Amazon Corretto 17.0.20.1 LTS
- **Compiler:** `javac 17.0.20.1`

## Commands

Each option works with its number or its command name:

- `1` / `on` — Turn the remote on.
- `2` / `off` — Turn the remote off.
- `3` / `temp` — Display the current temperature.
- `4` / `exit` — Terminate the program.
- `5` / `up` — Increase the temperature by 1°C, up to 30°C.
- `6` / `down` — Decrease the temperature by 1°C, down to 16°C.

The temperature starts at 24°C. Temperature commands require the remote to be ON.

## Compile and Run

Open a terminal in the `PanasonicRemote` directory and run:

```bash
javac -encoding UTF-8 PanasonicRemote.java
java PanasonicRemote
```

## How Java Runs the Program

`javac` compiles `PanasonicRemote.java` into Java bytecode stored in `PanasonicRemote.class`. The `java` command starts the Java Virtual Machine (JVM), which loads and runs the bytecode. The JVM can interpret bytecode and use the Just-In-Time (JIT) compiler to compile frequently executed code into native machine code. Java bytecode can run on systems with a compatible JVM.
