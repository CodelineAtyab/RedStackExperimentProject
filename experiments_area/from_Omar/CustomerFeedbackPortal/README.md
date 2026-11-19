# Customer Feedback Portal HashMap Exercise

This folder contains the Java practice work for the HashMap-based customer feedback portal.

## Files

- `FeedbackLookup.java` — demonstrates a simple `HashMap<String, String>` lookup using `put()` and `get()`.
- `FeedbackPortal.java` — demonstrates a nested `HashMap<String, HashMap<String, String>>` structure for customer records.

## Requirements covered

- Both Java files compile successfully with `javac --release 17`.
- Both Java files run successfully with `java` and produce the expected output without errors.
- `FeedbackLookup.java` uses `HashMap<String, String>`, fills it with `put()`, and retrieves values with `get()`.
- `FeedbackPortal.java` uses `HashMap<String, HashMap<String, String>>`, with one inner map per customer, and reads values using `get()`.
- The values are not hard-coded in the output; they are printed from the HashMap entries.

## Run

From this folder, compile and run each file:

```bash
javac --release 17 FeedbackLookup.java
java FeedbackLookup
```

```bash
javac --release 17 FeedbackPortal.java
java FeedbackPortal
```

## Branch naming

This work follows the required branch naming format:

`feature/182-omar-feedback-portal-hashmap`

This keeps the task aligned with the repository naming convention for the HashMap feedback portal exercise.
