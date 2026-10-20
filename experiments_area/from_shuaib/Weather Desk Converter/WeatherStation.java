public class WeatherStation {

    double currentCelsius = 25.0;

    public double getFahrenheit() {
        return (currentCelsius * 9/5) + 32;
    }

    public double getKelvin() {
        return currentCelsius + 273.15;
    }
}
