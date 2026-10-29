# Panasonic Remote

A small Java console program that simulates a Panasonic remote control.

## Features

- Repeatedly displays a menu to turn the remote on or off, check the temperature, or exit.
- isRemoteOn variable now activates based on choice
- Accepts either the menu number or its text command:
  - `1` or `on` turns the remote on.
  - `2` or `off` turns the remote off.
  - `3` or `temp` displays the current temperature.
  - `4` or `exit` ends the program.
- Reports the remote's updated status after an on/off command.
- Displays a fixed temperature of 24°C.
- Prints an error message for commands that are not available menu choices.

## Compile and run

From this directory, compile with Java 17 and run the program:

- `javac --release 17 PanasonicRemote.java` compiles the Java source code into a class file.
- `java PanasonicRemote` runs the compiled program.

## JVM and JIT

The JVM (Java Virtual Machine) runs the compiled Java program. The JIT (Just-In-Time compiler) helps it run faster by turning frequently used parts into machine code while the program is running.
