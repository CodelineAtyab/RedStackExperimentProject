# PanasonicRemote

JDK version: 25.0.4.1

## How to run

```
javac PanasonicRemote.java
java PanasonicRemote
```

## JVM pipeline

The javac compiler translates the .java source file into byte-code stored in a .class file. The JVM loads this byte-code and runs it, so the same program works on any operating system. While the program runs, the JIT compiler finds the code that repeats a lot (hotspots) and translates it into native machine code to make it faster.