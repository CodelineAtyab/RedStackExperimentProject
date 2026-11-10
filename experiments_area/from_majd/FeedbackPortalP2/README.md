# FeedbackPortalP2

This project is a Java exercise that builds on the previous feedback portal concept by using inheritance and polymorphism.

## Purpose

The program demonstrates a simple feedback system where multiple feedback types can share a common base class while providing different summaries.

## Project Structure

- `CustomerFeedbackPortalp2.java` — contains the `main` method and creates a sample web-form feedback object
- `Feedback.java` — abstract base class for all feedback types
- `WebFormFeedback.java` — extends `Feedback` and overrides the summary output

## Key Concept

`Feedback` is declared as an abstract class, which means it cannot be instantiated directly. Instead, subclasses like `WebFormFeedback` implement the required behavior.

This allows the project to:

- share common feedback fields
- define reusable logic
- let each feedback type customize its summary output

## Example Output

```java
[Web] Aisha: Great service(5/5)
```

## How to Run

Compile the Java files:

```bash
javac *.java
```

Run the program:

```bash
java CustomerFeedbackPortalp2
```

## Learning Focus

This project helps practice:

- inheritance
- abstract classes
- method overriding
- object-oriented design
- building reusable class hierarchies

## Notes

This project is a beginner-friendly example of how Java classes can be structured to model different kinds of feedback while reusing shared code.
