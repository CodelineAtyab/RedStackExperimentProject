# FeedbackAbstraction

A Java experiment demonstrating abstraction, inheritance and polymorphism through a customer feedback model.

## Files

| File | Responsibility |
|---|---|
| `Feedback.java` | Abstract parent class with shared fields, getters, validated setters, abstract `getSummary()` and `toString()` |
| `WebFormFeedback.java` | Child class representing web feedback |
| `EmailFeedback.java` | Child class with an additional email address |
| `PhoneFeedback.java` | Child class with a phone number and call duration |
| `FeedbackPortal.java` | Stores all feedback in an `ArrayList<Feedback>`, prints a report and calculates the average rating |
| `Main.java` | Adds one of each feedback type to the portal, prints the report and average, and tests inherited validation |
| `UML.md` | UML class diagram showing inheritance and the portal's relationship to `Feedback` |

## Key Concepts

- Abstraction using the abstract `Feedback` class.
- Inheritance using `extends`.
- Parent constructor reuse using `super()`.
- Encapsulation using private fields and getters.
- Method overriding using `@Override`.
- Inherited validation through `setRating()`.

### Polymorphism

The portal only knows its objects as `Feedback`, but each object runs its own version of `getSummary()`. The same call produces a web, email or phone summary depending on the real type of the object.

### ArrayList&lt;Feedback&gt;

`FeedbackPortal` keeps every feedback object in one `ArrayList<Feedback>`. Because the list type is the abstract parent, it can hold `WebFormFeedback`, `EmailFeedback` and `PhoneFeedback` objects together.

### toString()

`Feedback` overrides `toString()` to return `#<id> <getSummary()>`, for example `#1 [Web] Aisha: Great service (5/5)`. It calls the abstract `getSummary()`, so every child prints in its own format without redefining `toString()`.

### One loop for all feedback types

`printReport()` uses a single `for` loop and `System.out.println(feedback)`. It never checks the object's type with `instanceof`, because `toString()` and `getSummary()` handle the differences.

### Average rating calculation

`getAverageRating()` returns `0` for an empty list. Otherwise it adds up every `getRating()` in an `int total` and divides by `allFeedback.size()`. The total is cast to `double` first so the result keeps its decimals instead of using integer division. `Main` shows it with one decimal place using `String.format("%.1f", ...)`.

## Run

```bash
javac *.java
java Main
```

## Expected Output

```text
#1 [Web] Aisha: Great service (5/5)
#2 [Email] Omar <omar@mail.com>: Slow reply (3/5)
#3 [Phone] Salma 99112233, 7 min: Helpful agent (4/5)
Average rating: 4.0
Invalid rating: 9
```
