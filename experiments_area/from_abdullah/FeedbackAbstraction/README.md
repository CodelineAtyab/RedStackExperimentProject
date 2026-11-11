# Feedback Abstraction

This Java example demonstrates **abstraction** with an abstract `Feedback` base
class and a concrete `WebFormFeedback` implementation. The base class holds
shared feedback data and requires subclasses to provide a summary.

## Files

- `Feedback.java` — Abstract base class with private feedback fields, getters,
  input validation, and the abstract `getSummary()` method.
- `WebFormFeedback.java` — Concrete subclass that formats a web-form feedback
  summary.
- `Main.java` — Creates a `WebFormFeedback` instance and prints its summary.

Because `Feedback` is abstract, it cannot be instantiated directly. A concrete
subclass must implement `getSummary()`.

## Run

From this folder, compile and run the example:

```text
javac *.java
java Main
```

## Example Output

```text
[Web] Aisha: Great service (5/5)
```
