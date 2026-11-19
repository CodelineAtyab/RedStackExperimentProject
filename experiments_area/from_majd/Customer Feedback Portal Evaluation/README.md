# Customer Feedback Portal Evaluation

This project is a Java-based customer feedback management system. It allows users to submit product reviews, view all feedback, generate rating summaries, search feedback by product, and save results to a local data file.

## Features

- Submit customer feedback with name, product, rating, and comment
- View all stored feedback entries
- Generate a rating report for each product
- Search feedback by product name
- Save feedback to a file and reload it on startup
- Exit the portal after saving the latest data

## Project File

- `CustomerFeedbackPortal.java` — main Java application

## How to Run

From the project folder, compile and run the program:

```bash
javac CustomerFeedbackPortal.java
java CustomerFeedbackPortal
```

## Notes

- Feedback data is stored in a file named `feedbacks.txt` in the working directory.
- The portal supports a simple menu-driven console interface.
- The program is intended for basic evaluation and practice in Java collections, file handling, and console-based user interfaces.
