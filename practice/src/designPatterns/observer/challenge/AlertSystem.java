package designPatterns.observer.challenge;

public class AlertSystem implements WeatherObserver{
    private float windSpeed;
    private float temperature;
    private float pressure;
    Subject weatherStation;

    public AlertSystem(Subject weatherStation){
        this.weatherStation=weatherStation;
        weatherStation.registerObserver(this);
    }

    @Override
    public void updateWeatherData(float windSpeed, float temperature, float pressure) {
        this.windSpeed=windSpeed;
        this.temperature=temperature;
        this.pressure=pressure;
        alert();
    }

    public void alert(){
        System.out.println("====Alerting===");
        System.out.println("Alerting Wind speed: "+windSpeed);
        System.out.println("Alerting Temperature: "+temperature);
        System.out.println("Alerting Pressure: "+pressure);
    }
}
