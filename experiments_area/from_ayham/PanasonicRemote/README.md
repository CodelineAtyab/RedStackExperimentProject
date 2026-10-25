JDK: Amazon Corretto 17.0.20.1 (LTS)

Run:
PanasonicRemote % javac PanasonicRemote.java
 --- creates PanasonicRemote.class

PanasonicRemote % java PanasonicRemote
Choose an option: 1) on   2) off   3) temp   4) exit

`javac` compiles Java source code into bytecode stored in `.class` files. The JVM (Java Virtual Machine) runs that bytecode. The JIT (Just-In-Time) compiler is part of the JVM and compiles frequently used bytecode into native machine code while the program runs. This lets Java programs run on systems with a compatible JVM.