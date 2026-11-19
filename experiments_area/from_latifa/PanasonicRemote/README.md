#JDK Version 
openjdk version "17.0.20.1" 2026-08-18 LTS

#javac compiles .java files into byte-code (.class).
run this -->
        javac PanasonicRemote.java
        java PanasonicRemote.java

#How the JVM loads that byte-code.
The JVM loads the .class file and executes the bytecode.
During execution, the JVM manages memory and runtime operations.

#The JIT (Just-In-Time) compiler converts frequently used code into native machine code. This improves application performance while the program is running.