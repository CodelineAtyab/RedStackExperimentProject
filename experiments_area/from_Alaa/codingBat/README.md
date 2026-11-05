# CodingBat Java Practice

## Overview
This folder contains my solutions to Java programming exercises from CodingBat. The exercises help me practise Java fundamentals, including arrays, strings, conditional statements, loops, methods, and basic problem-solving.

## Requirements
- **Java JDK:** 17 (Amazon Corretto 17)
- **Terminal:** PowerShell, Command Prompt, or another terminal
- **Editor:** Any text editor or IDE that supports Java

## Project Structure

```text
codingbat/
├── ArrayOne.java
├── StringOne.java
└── WarmupOne.java
```

## Exercises Covered

### 1. WarmupOne.java
Practises basic Java logic, conditionals, strings, and mathematical operations.

Methods implemented:
- `sleepIn()` – Determines whether to sleep in based on the weekday and vacation.
- `monkeyTrouble()` – Checks whether two monkeys are smiling at the same time.
- `sumDouble()` – Returns the sum of two numbers, doubling it when the numbers are equal.
- `diff21()` – Calculates the difference from 21, doubling the difference when the number exceeds 21.
- `parrotTrouble()` – Checks whether a talking parrot causes trouble outside the permitted hours.
- `makes10()` – Checks whether either number or their sum equals 10.
- `nearHundred()` – Checks whether a number is within 10 of 100 or 200.
- `everyNth()` – Returns characters at intervals of `n`.
- `endUp()` – Converts the last three characters of a string to uppercase.
- `lastDigit()` – Checks whether two integers have the same last digit.
- `stringE()` – Checks whether a string contains between one and three occurrences of `e`.
- `max1020()` – Finds the maximum number when at least one number is between 10 and 20.
- `max3050()` – Finds the maximum number when at least one number is between 30 and 40.

### 2. StringOne.java
Practises string concatenation, substring operations, and string manipulation.

Methods implemented:
- `helloName()` – Returns a greeting containing a name.
- `makeAbba()` – Combines two strings in the pattern `a + b + b + a`.
- `makeTags()` – Wraps a word in opening and closing tags.
- `makeOutWord()` – Inserts a word into the middle of a four-character string.
- `extraEnd()` – Repeats the last two characters of a string three times.
- `firstTwo()` – Returns the first two characters, or the entire string if it is shorter.
- `firstHalf()` – Returns the first half of a string.
- `withoutEnd()` – Returns a string without its first and last characters.
- `comboString()` – Combines two strings by placing the shorter string at both ends.

### 3. ArrayOne.java
Practises array indexing, accessing elements, and returning arrays.

Methods implemented:
- `firstLast6()` – Checks whether the first or last array element is 6.
- `sameFirstLast()` – Checks whether the first and last elements are equal.
- `makePi()` – Returns an integer array containing `{3, 1, 4}`.
- `commonEnd()` – Checks whether two arrays have the same first elements or the same last elements.
- `sum3()` – Returns the sum of an array containing exactly three elements.
- `rotateLeft3()` – Returns a new array with three elements rotated one position to the left.

## How to Compile and Run

Open a terminal in the `codingbat` folder.

### Compile all Java files

```bash
javac ArrayOne.java StringOne.java WarmupOne.java
```

### Run the programs

Run each class separately:

```bash
java ArrayOne
```

```bash
java StringOne
```

```bash
java WarmupOne
```

Each class contains a `main()` method that runs sample calls to its implemented methods and prints the results.

## Learning Objectives
- Practise Java methods and return types.
- Understand `if` and `else` statements and Boolean expressions.
- Work with `for` loops and string iteration.
- Use arrays and access elements through indexes.
- Manipulate strings using concatenation, `substring()`, and `charAt()`.
- Improve logical thinking and problem-solving skills.

## Author
Alaa Ahmed Alrashdi
