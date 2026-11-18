```mermaid
classDiagram
    class FeedbackPortal {
        -ArrayList~Feedback~ allFeedback
        +addFeedback(Feedback feedback) : void
        +printReport() : void
        +getAverageRating() : double
    }

    class Feedback {
        <<abstract>>
        -int id
        -String customerName
        -String message
        -int rating
        +getRating() : int
        +getSummary()* : String
        +toString() : String
    }

    class WebFormFeedback {
        +getSummary() : String
    }

    class EmailFeedback {
        -String emailAddress
        +getSummary() : String
    }

    class PhoneFeedback {
        -String phoneNumber
        -int callMinutes
        +getSummary() : String
    }

    FeedbackPortal o-- "*" Feedback
    Feedback <|-- WebFormFeedback
    Feedback <|-- EmailFeedback
    Feedback <|-- PhoneFeedback