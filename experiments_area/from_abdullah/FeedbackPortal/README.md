# Feedback Portal

This folder contains three small Java console programs that demonstrate working
with feedback data using arrays, a two-dimensional array, and an `ArrayList`.
They are standalone learning examples; they do not form a connected portal
application.

## Programs

- **`FeedbackComments`** stores sample comments in an `ArrayList`, prints the
  third comment, then iterates through the list with a for-each loop, an
  index-based loop, and `forEach`.
- **`FeedbackRatings`** pairs three sample customer names with ratings from 3
  through 5 using parallel arrays.
- **`FeedbackScoreTable`** stores service, price, and speed scores for three
  customers in a 3 × 3 array, then prints the scores row by row.

## Requirements

- Java Development Kit (JDK) 8 or later

## Compile and run

Open a terminal in this folder, compile the Java files, and run any program:

```text
javac FeedbackComments.java FeedbackRatings.java FeedbackScoreTable.java
java FeedbackComments
java FeedbackRatings
java FeedbackScoreTable
```

Each `java` command runs its corresponding program independently.
