# FeedbackPortalp3

This project extends the previous feedback portal examples by adding multiple feedback channels through inheritance and specialized subclasses.

## Purpose

The program demonstrates how a single abstract feedback model can support different submission types, such as:

- email feedback
- phone feedback

Each type has its own extra information and a custom summary format.

## Files

- `FeedbackPortalp3.java` — main class that creates and displays different feedback types
- `Feedback.java` — abstract base class with shared feedback properties
- `EmailFeedback.java` — subclass for email-based feedback with an email address
- `PhoneFeedback.java` — subclass for phone-based feedback with a phone number and call duration

## Core Concept

The `Feedback` class defines common fields:

- `id`
- `customerName`
- `message`
- `rating`

It also declares an abstract method:

```java
public abstract String getSummary();
```

Each subclass provides its own implementation of `getSummary()`, which allows each feedback type to format output differently.

## Example Output

```java
[Email] Omar<omar@gmail.com>: Slow reply(3/5)
[Phone] Salma<99112233>, 7 min: Helpful agent(4/5)
```

## How to Run

Compile all Java files in the folder:

```bash
javac *.java
```

Run the main class:

```bash
java FeedbackPortalp3
```

## Learning Focus

This project helps practice:

- abstract classes
- inheritance
- method overriding
- object-oriented design
- subclass-specific data and behavior

## Notes

This is a simple Java exercise for understanding how to model related objects with shared behavior but different specialized details.
