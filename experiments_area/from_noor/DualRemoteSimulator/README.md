
# Dual Remote Simulator

Java 17+ project demonstrating Encapsulation, Abstraction, Inheritance, and Polymorphism.

## Run

From the project directory:

```bash
javac -d out src/main/java/*.java
java -cp out Main
```

## OOP Concepts

- Encapsulation: private state and helper methods in LGTVRemote and LGACRemote.
- Abstraction: RemoteCover defines the shared remote operations.
- Inheritance: both concrete remotes extend RemoteCover.
- Polymorphism: Main uses a RemoteCover reference to operate either remote.

To switch devices, change the object assigned to `remote` in Main.java.
