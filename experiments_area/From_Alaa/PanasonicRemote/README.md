# PanasonicRemote

## JDK version
openjdk 17.0.20.1 2 and javac 17.0.20.1

## How to compile?
To compile the code (Java file in plaintext)---> (bytecode(which is PanasonicRemote.class)) we run :
```
javac PanasonicRemote.java
```

##  How to run in the Laptop?
To run this projectand we run this in the terminal and make sure we are on the right directory :
```
java .\PanRemot.java
```

## JVM and JIT Explenation:
When I run (javac PanasonicRemote.java), the compiler reads my Java file and turns it into bytecode. It saves that bytecode in (PanasonicRemote.class). Then the JVM loads the bytecode and starts running it. While the program runs, the JIT compiler looks for code that runs many times (called hotspots) and turns it into native machine code. The computer can run that native code directly, so it is faster.


