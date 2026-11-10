# UML Diagram

```mermaid
classDiagram
    class Feedback {
        <<abstract>>
        -int id
        -String customerName
        -String message
        -int rating
        +Feedback(int, String, String, int)
        +getId() int
        +getCustomerName() String
        +getMessage() String
        +getRating() int
        +setMessage(String) void
        +setRating(int) void
        +getSummary() String*
    }

    class WebFormFeedback {
        +WebFormFeedback(int, String, String, int)
        +getSummary() String
    }

    Feedback <|-- WebFormFeedback
```
