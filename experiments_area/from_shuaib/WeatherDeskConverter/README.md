# Weather Desk Converter

A small Java console program that converts a temperature entered in Celsius to Fahrenheit and Kelvin.

## How it works

`TemperatureConverter` prompts for a Celsius value, then uses `WeatherStation` to calculate and print the Fahrenheit and Kelvin equivalents.

## Run

From this directory, compile the Java files and start the program with Java 17:

```sh
javac --release 17 TemperatureConverter.java WeatherStation.java
java TemperatureConverter
```

Enter a numeric temperature in Celsius when prompted.
