# Weather Desk Converter

Two small Java programs for converting Celsius temperatures to Fahrenheit and Kelvin.

## JDK Version

Amazon Corretto 17.0.20.1 (64-bit)

## TemperatureConverter

Reads a Celsius temperature from the user, calculates Fahrenheit and Kelvin, and prints both results.

Compile:

```powershell
javac TemperatureConverter.java
```

Run:

```powershell
java TemperatureConverter
```

## WeatherStation

Stores the Celsius temperature in a field and provides `getFahrenheit()` and `getKelvin()` methods to calculate the converted values.

Compile:

```powershell
javac WeatherStation.java
```

Run:

```powershell
java WeatherStation
```

## How the JVM Works

The `javac` compiler translates Java source code into bytecode stored in `.class` files. When the `java` command starts a program, the JVM loads and verifies the bytecode before executing it. The JVM can interpret bytecode and use its Just-In-Time (JIT) compiler to translate frequently executed code into native machine instructions. This allows Java programs to run on systems with a compatible JVM.