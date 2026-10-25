# Panasonic Remote Problem

A small Java console program that simulates a Panasonic remote menu.

## Features

- Displays options to turn the remote on or off, check the temperature, or exit.
- Accepts either the option number or its text command:
  - `1` or `on`
  - `2` or `off`
  - `3` or `temp`
  - `4` or `exit`
- Reports a fixed current temperature of 24°C.

The on and off options currently print a status message; they do not change the remote's state.

## Compile and run

From this directory, compile with Java 17 and run the program:

```sh
javac --release 17 PanasonicRemote.java
java PanasonicRemote
```
