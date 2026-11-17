# Bracket Validator

A standalone Java command-line exercise that checks whether parentheses, curly braces, and square brackets in an expression are balanced and correctly nested. Characters other than brackets are ignored.

## Files

- `BracketValidator.java` - contains the validation logic and a `main` method with a sample expression.

## Compile and run

From this directory, compile with Java 17 and run:

```sh
javac --release 17 BracketValidator.java
java BracketValidator
```

The included sample expression, `(()}`, is invalid because its opening parentheses are not properly matched.
