# PanasonicRemote

A Java command-line application that simulates a Panasonic air conditioner remote.

## Requirements

- **JDK:** Amazon Corretto 17.0.20.1
- **Terminal:** Windows Command Prompt (CMD) or VS Code terminal

## Features

- Turn the air conditioner on and off.
- View and change the temperature when the AC is on.
- Validate temperature input between 16°C and 30°C.
- Repeat the menu until the user exits.

## Compile

```bash
javac PanasonicRemote.java
```

## Run

```bash
java PanasonicRemote
```

## How the JVM Works

The `javac` compiler translates `PanasonicRemote.java` into JVM bytecode stored in `PanasonicRemote.class`. When the `java` command starts the program, the JVM loads the class and verifies its bytecode before execution. The JVM executes the bytecode and may use its Just-In-Time (JIT) compiler to translate frequently executed code into native machine instructions. This allows Java programs to run on systems with a compatible JVM.