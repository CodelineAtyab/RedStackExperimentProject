# Customer Feedback HashMap

This folder contains two small Java examples that store and retrieve customer feedback using `HashMap`.

## Files

- **`FeedbackLookup.java`** — Maps customer IDs to feedback comments and looks up several IDs. Looking up an ID that is not present returns `null`.
- **`FeedbackPortal.java`** — Maps customer IDs to nested maps containing customer names, ratings, and comments. It also demonstrates that requesting a field that is not present returns `null`.

## Requirements

- Java Development Kit (JDK), with `javac` and `java` available on your command line.

## Compile and run

From this folder, compile both examples:

```bash
javac FeedbackLookup.java FeedbackPortal.java
```

Run either example:

```bash
java FeedbackLookup
java FeedbackPortal
```

Each class has its own `main` method and can be run independently.
