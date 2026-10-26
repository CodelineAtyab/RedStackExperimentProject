# Tic-Tac-Toe

## Purpose

This exercise builds the basic parts of a Tic-Tac-Toe game in Java. It includes a 3 × 3 board, a method to display the board in the terminal, and a list of recorded moves. It does not play a full game yet. Its goal is to practise two-dimensional arrays, nested loops, and `ArrayList`.

## Why a two-dimensional `char` array

The board always has exactly 3 rows and 3 columns, so a fixed-size array fits well. `char[][] board = new char[3][3]` stores one character per cell (`'X'`, `'O'`, or `' '`). Each cell is accessed using two indexes: `board[row][col]`. An `ArrayList` is not needed for the board because its size never changes.

## How the nested loops work

- **Initializing:** The constructor uses an outer loop for the rows and an inner loop for the columns. Together, they visit all 9 cells and set each one to a space (`' '`), so the board starts empty.
- **Printing:** `printBoard()` uses the same two loops. It prints each cell, places `|` between cells, and prints a line of dashes between rows.

## Why `ArrayList<String>` for the moves

The number of moves can change as the game progresses. An `ArrayList` grows when you call `add()`, keeps moves in insertion order, and supports a for-each loop to print them. Each sample move is a `String`, such as `"X at row 0, col 0"`.

## Compile and run

From this folder, run:

```powershell
javac --release 17 TicTacToe.java
java TicTacToe
```

Expected output:

```text
   |   |   
---------
   |   |   
---------
   |   |   
X at row 0, col 0
O at row 1, col 1
X at row 2, col 2
```