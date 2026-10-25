# PanasonicRemote

A Java command-line program that simulates a Panasonic AC remote.

## Commands

Each option works with its number or its word:

- `1` / `on` prints `Remote is now ON`
- `2` / `off` prints `Remote is now OFF`
- `3` / `temp` prints `Current temperature: 24°C`
- `4` / `exit` stops the program

## Compile and run

```bash
javac -encoding UTF-8 PanasonicRemote.java
java PanasonicRemote
```

## javac, the JVM and the JIT

`javac` compiles `PanasonicRemote.java` into bytecode stored in `PanasonicRemote.class`. The `java` command starts the JVM, which loads and runs that bytecode. The JVM can interpret bytecode as the program runs. The JIT compiler turns frequently executed bytecode into native machine code to improve performance. Java bytecode can run on any system with a compatible JVM.