public class WeatherStation {

    public double currentCelsius = 25.0;

    public double getFahrenheit() {
        return (currentCelsius * 9.0 / 5.0) + 32.0;
    }

    public double getKelvin() {
        return currentCelsius + 273.15;
    }
}