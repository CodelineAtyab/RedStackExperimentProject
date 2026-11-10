# Customer Feedback Portal

This exercise is kept in its own practice folder, under `experiments_area/from_Omar/Customer_Feedback_Portal/`, with no loose Java files left in the member root.

## Project requirements

This project follows the required Java data-structure exercises:

- All three files compile with `javac --release 17` and run with `java` without errors.
- `FeedbackRatings.java` uses `String[]` and `int[]` with a size of 3, fills the values in a `for` loop, and prints exactly the three required lines.
- `FeedbackComments.java` uses a `List<String>` filled with `add()`, reads the third comment with `get(2)`, and prints all five comments under each of the three headers exactly as required.
- `FeedbackComments.java` demonstrates all three iteration styles: enhanced `for` loop, traditional index loop, and `forEach` with a lambda.
- `FeedbackScoreTable.java` uses an `int[][]` array of size `3x3`, loops through each row and column, and prints exactly the three required lines.

## Run

From this folder, compile and run each file using Java 17:

```bash
javac --release 17 FeedbackRatings.java
java FeedbackRatings
```

```bash
javac --release 17 FeedbackComments.java
java FeedbackComments
```

```bash
javac --release 17 FeedbackScoreTable.java
java FeedbackScoreTable
```

## Branch naming

This work follows the expected branch naming pattern:

`feature/143-<your-id>-feedback-portal-datastructures`

Example:

`feature/143-omar-feedback-portal-datastructures`
