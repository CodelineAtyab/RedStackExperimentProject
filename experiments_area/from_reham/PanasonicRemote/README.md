# Panasonic Remote

A simple Java program that simulates a Panasonic remote control.

## JDK Version

- **Local development:** Oracle JDK 27 (27+35-2325)
- **CI environment:** Amazon Corretto 17

The project should remain compatible with Java 17 if CI uses Java 17.

## How to Run

1. Compile the program:

bash
   javac PanasonicRemote.java


2. Run the program:

   bash
   java PanasonicRemote
   

## JVM and JIT Explanation

- **JVM (Java Virtual Machine):** The JVM loads and executes Java bytecode. It allows Java programs to run on different operating systems with a compatible Java runtime.
- **JIT (Just-In-Time Compiler):** The JIT is part of the JVM. It compiles frequently executed bytecode into native machine code at runtime to improve performance.

## JVM Execution Pipeline

1. Write the source code in `PanasonicRemote.java`.
2. The Java compiler (`javac`) compiles the source code into bytecode.
3. The bytecode is saved in `PanasonicRemote.class`.
4. The JVM loads and executes the bytecode.
5. The JIT compiler optimizes frequently executed code by compiling it into native machine code at runtime.
