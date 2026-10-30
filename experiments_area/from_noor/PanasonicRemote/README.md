# PanasonicRemote

JDK used for development: Amazon Corretto 25.0.4.1

CI uses Amazon Corretto 17.

## How to run

```bash
javac PanasonicRemote.java
java PanasonicRemote
```

## JVM pipeline

The `javac` compiler translates the `.java` source file into bytecode stored in a `.class` file. The JVM loads and runs this bytecode, allowing Java programs to run on different operating systems with a compatible JVM. While the program runs, the JIT compiler identifies frequently executed code (hotspots) and compiles it into native machine code to improve performance.