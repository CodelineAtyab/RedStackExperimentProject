# Temperature Converter

This project is a simple Java command-line program that converts a temperature from Celsius to Fahrenheit and Kelvin.

## What it does

The program:
- asks the user to enter a temperature in Celsius
- converts it to Fahrenheit using:
  - `F = (C * 9 / 5) + 32`
- converts it to Kelvin using:
  - `K = C + 273.15`
- prints both results to the console

## Files

- `TemperatureConverter.java` - main Java source file

## Run it

From the project folder, compile and run the program with:
\
```bash
javac TemperatureConverter.java
java TemperatureConverter
```

## Example

```text
Enter temperature value in celsius:
25
Fahrenheit: 77.0 / Kelvin: 298.15
```

## Notes

This is a beginner Java exercise designed to practice:
- user input with `Scanner`
- methods and variables
- basic arithmetic and output formatting
