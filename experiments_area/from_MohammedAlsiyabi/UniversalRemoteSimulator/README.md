# Dual-Remote Simulator

A small Java 17+ program that simulates an LG TV remote and an LG AC remote
through one abstract class, `RemoteCover`. All files are in one flat folder.

## Quick start
```bash
# Compile
javac *.java

# Run with TV remote
java Main TV

# Run with AC remote
java Main AC
```

## Where to find the OOP concepts
- **Encapsulation:** private helpers `powerToggle()`, `changeChannel()`,
  `increaseTemperature()` and `decreaseTemperature()` in the two remotes.
- **Abstraction:** `RemoteCover` declares six methods without bodies; `Main`
  only uses the type `RemoteCover`.
- **Inheritance:** `LGTVRemote` and `LGACRemote` extend `RemoteCover` and reuse `formatStatus(...)`.
- **Polymorphism:** the single `RemoteCover remote = ...` line in `Main`.