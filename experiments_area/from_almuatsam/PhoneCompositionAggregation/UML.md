# Part B UML: Smartphone, Battery, SimCard

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
        +drain(int amount) void
        +getLevel() int
    }

    class SimCard {
        -String number
        +SimCard(String number)
        +getNumber() String
    }

    Smartphone *-- "1" Battery : owns (composition)
    Smartphone o-- "0..1" SimCard : holds (aggregation)
```

- **Filled diamond (composition):** `Smartphone` creates and owns its `Battery`. It cannot exist without the phone.
- **Empty diamond (aggregation):** `Smartphone` only holds a reference to a `SimCard` created elsewhere. The SIM can be removed and moved to another phone.
- **Visibility:** `-` private, `+` public, `~` package-private (the `Battery` constructor).
