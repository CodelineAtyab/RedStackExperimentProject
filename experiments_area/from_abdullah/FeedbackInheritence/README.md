# Feedback Inheritance

This Java example demonstrates inheritance and polymorphism with feedback
submitted through different channels. The abstract `Feedback` class contains
shared feedback data and validation, while each channel-specific subclass
provides its own implementation of `getSummary()`.

## Files

- `Feedback.java` — Abstract base class with private fields, getters, message
  and rating validation, and the abstract `getSummary()` method.
- `WebFormFeedback.java` — Represents feedback submitted through a web form.
- `EmailFeedback.java` — Adds an email address to email feedback.
- `PhoneFeedback.java` — Adds a phone number and call duration to phone
  feedback.
- `Main.java` — Creates and prints an example of each feedback type, then
  demonstrates rating validation.

`Feedback` cannot be instantiated directly because it is abstract. Each
subclass inherits its shared fields and validation behavior and overrides
`getSummary()` to format its own output.

## Run

From this folder, compile and run the example:

```text
javac *.java
java Main
```

## Example Output

```text
[Web] Aisha: Great service (5/5)
[Email] Omar <omar@mail.com>: Slow reply (3/5)
[Phone] Salma 99112233, 7 min: Helpful agent (4/5)
Invalid rating: 9
```
