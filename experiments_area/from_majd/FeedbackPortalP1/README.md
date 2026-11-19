# FeedbackPortalP1

This project is a small Java exercise for managing customer feedback entries.

## Purpose

The program demonstrates a simple feedback model where a customer can submit:

- an ID
- a customer name
- a message
- a rating from 1 to 5

It shows basic Java class design, field encapsulation, getters/setters, validation, and object creation.

## Files

- `CustomerFeedbackPortal.java` — contains the main program and creates a sample feedback object
- `Feedback.java` — defines the `Feedback` class with data and validation logic
- `Feedback.class` — compiled bytecode generated after javac compilation

## Features

- Stores feedback details in a `Feedback` object
- Validates empty messages
- Validates rating range (`1` to `5`)
- Prints the feedback summary to the console

## Example Output

```java
Aisha | Message | 5
```

## How to Run

From the project folder, compile the Java files:

```bash
javac *.java
```

Then run the main class:

```bash
java CustomerFeedbackPortal
```

## Notes

This is a beginner-friendly Java practice project focused on object-oriented programming and basic input validation.
