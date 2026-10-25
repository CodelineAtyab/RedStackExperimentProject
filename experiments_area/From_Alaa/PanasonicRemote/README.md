# PanasonicRemote

## JDK Version

OpenJDK 17.0.20.1

## How to Compile

Open a terminal in the directory containing `PanasonicRemote.java` and run:

```bash
javac PanasonicRemote.java
```

This compiles the Java source file into bytecode and creates `PanasonicRemote.class`.

## How to Run

Run the compiled program using:

```bash
java PanasonicRemote
```

## JVM and JIT Explanation

When I run `javac PanasonicRemote.java`, the Java compiler converts my source code into bytecode and saves it in `PanasonicRemote.class`.

The JVM (Java Virtual Machine) loads and executes this bytecode. While the program runs, the JIT (Just-In-Time) compiler can compile frequently executed code into native machine code to improve performance.
