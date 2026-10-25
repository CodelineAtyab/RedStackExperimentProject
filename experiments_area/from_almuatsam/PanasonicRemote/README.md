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

`javac` compiles `PanasonicRemote.java` into bytecode saved in `PanasonicRemote.class`. The `java` command starts the JVM, which loads that bytecode and runs it. The JVM first interprets the bytecode line by line. The JIT compiler watches for code that runs often and turns it into native machine code so it runs faster. Because the bytecode is the same everywhere, the program runs on any machine that has a JVM.
