public class WeatherStation {

    public double Celsius = 25.0;

    public double convertCelsiusToFahrenheit(double Celsius) {
        double Fahrenheit = Celsius * 9 / 5 + 32;
        return Fahrenheit;
    }

    public double convertCelsiusToKelvin(double Celsius) {
        double Kelvin = Celsius + 273.15;
        return Kelvin;
    }
}
