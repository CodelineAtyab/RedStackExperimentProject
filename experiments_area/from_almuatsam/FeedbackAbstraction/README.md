# FeedbackAbstraction

A small Java experiment that demonstrates abstraction using a customer feedback model.

## Files

| File | Responsibility |
|---|---|
| `Feedback.java` | Abstract parent class with four private fields, getters, validated setters, and the abstract method `getSummary()` |
| `WebFormFeedback.java` | Child class that extends `Feedback` and implements `getSummary()` |
| `Main.java` | Creates a `WebFormFeedback` object and prints its summary |
| `UML.md` | UML diagram of the class relationship |

## Key Ideas

- `Feedback` is declared `abstract`, so it cannot be instantiated directly.
- `getSummary()` has no body in `Feedback`, so every concrete child class must implement it.
- `WebFormFeedback` calls `super(...)` to reuse the parent constructor and its validation.

## Run

```bash
javac Feedback.java WebFormFeedback.java Main.java
java Main
```

## Expected Output

```text
[Web] Aisha: Great service (5/5)
```