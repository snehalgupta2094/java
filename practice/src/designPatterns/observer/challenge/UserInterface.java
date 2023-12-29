package designPatterns.observer.challenge;

public class UserInterface implements WeatherObserver{
    private float windSpeed;
    private float temperature;
    private float pressure;
    Subject weatherStation;

    public UserInterface(Subject weatherStation){
        this.weatherStation=weatherStation;
        weatherStation.registerObserver(this);
    }

    @Override
    public void updateWeatherData(float windSpeed, float temperature, float pressure) {
        this.windSpeed=windSpeed;
        this.temperature=temperature;
        this.pressure=pressure;
    }

    public void display(){
        System.out.println("====Display===");
        System.out.println("Displaying Wind speed: "+windSpeed);
        System.out.println("Displaying Temperature: "+temperature);
        System.out.println("Displaying Pressure: "+pressure);
    }
}
