# FeedbackAbstraction

A Java experiment demonstrating abstraction and inheritance through a customer feedback model.

## Files

| File | Responsibility |
|---|---|
| `Feedback.java` | Abstract parent class with shared fields, getters, validated setters, and abstract `getSummary()` |
| `WebFormFeedback.java` | Child class representing web feedback |
| `EmailFeedback.java` | Child class with an additional email address |
| `PhoneFeedback.java` | Child class with a phone number and call duration |
| `Main.java` | Creates feedback objects and tests inherited validation |
| `UML.md` | UML class diagram showing inheritance |

## Key Concepts

- Abstraction using the abstract `Feedback` class.
- Inheritance using `extends`.
- Parent constructor reuse using `super()`.
- Encapsulation using private fields and getters.
- Method overriding using `@Override`.
- Inherited validation through `setRating()`.

## Run

```bash
javac Feedback.java WebFormFeedback.java EmailFeedback.java PhoneFeedback.java Main.java
java Main
```

## Expected Output

```text
[Web] Aisha: Great service (5/5)
[Email] Omar <omar@mail.com>: Slow reply (3/5)
[Phone] Salma 99112233, 7 min: Helpful agent (4/5)
Invalid rating: 9
```