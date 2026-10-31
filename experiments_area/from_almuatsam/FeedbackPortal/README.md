# Feedback Portal

## 1. Purpose of the Feedback Portal exercise

This exercise models a small customer feedback portal and uses it to practise Java's basic data structures. Each program stores feedback in a different structure, so the same idea (collecting what customers say) is handled three ways:

- `FeedbackRatings` uses two parallel arrays for names and ratings.
- `FeedbackComments` uses a `List<String>` for free-text comments.
- `FeedbackScoreTable` uses a 3 × 3 two-dimensional array for scores.

The aim is to see when each structure fits and how to loop over it.

## 2. How arrays store customer names and ratings

An array is a fixed-size block of slots, all of the same type, accessed by a zero-based index. `FeedbackRatings` creates two arrays of length 3:

- `String[] customerNames` holds the names.
- `int[] ratings` holds one rating per customer.

The two arrays are linked by position: `customerNames[0]` and `ratings[0]` describe the same customer, and so on. The size is set when the array is created and cannot change afterwards. A `for` loop from `0` to `length - 1` walks both arrays together and prints each pair.

## 3. How `List<String>` stores comments and how the three loop styles work

A `List<String>` is a resizable, ordered collection. `FeedbackComments` uses an `ArrayList`, so comments are added with `add(...)` and the list grows as needed, unlike an array. Items keep their insertion order and are read with `get(index)`.

The program prints the same comments with three loop styles:

1. **Index loop**: `for (int i = 0; i < comments.size(); i++)` uses `comments.get(i)`. It gives you the index, which is useful when position matters.
2. **For-each loop**: `for (String comment : comments)` hands you each element directly. It is shorter and avoids index mistakes.
3. **`forEach` with a lambda**: `comments.forEach(comment -> System.out.println(comment))` passes the action to the list as a function. It is the most compact form.

## 4. How the 3 × 3 array stores scores for service, price, and speed

`int[][] scores = new int[3][3]` is an array of arrays, which works like a table:

- Each **row** is a customer (Almuatsam, Ayham, Salim).
- Each **column** is a category: column 0 is service, column 1 is price, column 2 is speed.

So `scores[1][2]` is Ayham's speed score. `printScoreTable` uses two nested loops: the outer loop goes through the customers (rows) and the inner loop goes through the categories (columns), printing one row per line.

## 5. Commands to compile and run each Java program

Run these from the `FeedbackPortal` folder:

```bash
javac FeedbackRatings.java
java FeedbackRatings

javac FeedbackComments.java
java FeedbackComments

javac FeedbackScoreTable.java
java FeedbackScoreTable
```

Or compile all three at once with `javac *.java`.
