# Customer Feedback Portal

A simple Java console application for collecting, viewing, and analyzing customer product feedback.

## Overview
This project lets users:
- submit customer feedback
- view all submitted feedback entries
- generate a rating report by product
- search feedback by product name
- save feedback to a text file
- exit cleanly after saving changes

## Files
- `CustomerFeedbackPortal.java` — main program logic
- `feedback.txt` — saved feedback data in pipe-delimited format

## Feedback file format
Each line in `feedback.txt` follows this structure:

```text
CustomerName|ProductName|Rating|Comment
```

Example:

```text
Ahmad|Laptop|5|Excellent battery life and fast performance
```

## How to run
From the project folder, compile and run the program:

```bash
javac CustomerFeedbackPortal.java
java CustomerFeedbackPortal
```

## Menu options
1. Submit Feedback
2. View All Feedback
3. Rating Report
4. Search by Product
5. Save to File
6. Exit

## Notes
- Ratings must be between 1 and 5.
- The program reads any saved entries from `feedback.txt` when started.
- Feedback is saved back to `feedback.txt` when you choose to save or exit.

## Example use case
A business can use this portal to collect product reviews from customers and quickly see which items are getting the strongest satisfaction scores.
