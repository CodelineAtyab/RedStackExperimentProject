# UML Class Diagram - Part B: Phone Composition & Aggregation

```mermaid
classDiagram
    class Smartphone {
        -String model
        -Battery battery
        -SimCard simCard
        +Smartphone(String model)
        +insertSim(SimCard simCard) void
        +removeSim() void
        +makeCall(int minutes) void
        +printStatus() void
    }
    class Battery {
        -int level
        ~Battery()
        +getLevel() int
        +drain(int amount) void
    }
    class SimCard {
        -String number
        +SimCard(String number)
        +getNumber() String
    }
    Smartphone *-- Battery : owns
    Smartphone o-- SimCard : holds