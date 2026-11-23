# UML Class Diagram - Part A: Open/Closed Payments

```mermaid
classDiagram
    class PaymentMethod {
        <<abstract>>
        +pay(double amount)* void
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