package designPatterns.observer.challenge;

public class Logger implements WeatherObserver{
    private float windSpeed;
    private float temperature;
    private float pressure;
    Subject weatherStation;

    public Logger(Subject weatherStation){
        this.weatherStation=weatherStation;
        weatherStation.registerObserver(this);
    }

    @Override
    public void updateWeatherData(float windSpeed, float temperature, float pressure) {
        this.windSpeed=windSpeed;
        this.temperature=temperature;
        this.pressure=pressure;
    }

    public void log(){
        System.out.println("====Log===");
        System.out.println("Logging Wind speed: "+windSpeed);
        System.out.println("Logging Temperature: "+temperature);
        System.out.println("Logging Pressure: "+pressure);
    }
}
