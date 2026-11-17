# Open/Closed Payments — UML (Part A)

```mermaid
classDiagram
    class PaymentMethod {
        <<abstract>>
        +pay(double amount) void
    }
    class CardPayment {
        +pay(double amount) void
    }
    class WalletPayment {
        +pay(double amount) void
    }
    class BankTransferPayment {
        +pay(double amount) void
    }
    class CashOnDeliveryPayment {
        +pay(double amount) void
    }
    class Checkout {
        +checkout(PaymentMethod method, double amount) void
    }

    PaymentMethod <|-- CardPayment
    PaymentMethod <|-- WalletPayment
    PaymentMethod <|-- BankTransferPayment
    PaymentMethod <|-- CashOnDeliveryPayment
    Checkout ..> PaymentMethod : uses
```

- **Inheritance (solid line, hollow arrow):** `CardPayment`, `WalletPayment`, `BankTransferPayment` and `CashOnDeliveryPayment` each extend `PaymentMethod` and override `pay`.
- **Dependency (dashed arrow):** `Checkout` uses `PaymentMethod`. It does not inherit from it, and it never refers to a specific payment class.
