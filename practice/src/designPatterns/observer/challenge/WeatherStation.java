package designPatterns.observer.challenge;

import java.util.ArrayList;

import designPatterns.observer.challenge.WeatherObserver;

public class WeatherStation implements Subject{
    private float windSpeed;
    private float temperature;
    private float pressure;
    private ArrayList<WeatherObserver> observers;

    public WeatherStation(){
        this.observers=new ArrayList<>();
    }

    @Override
    public void registerObserver(WeatherObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(WeatherObserver o) {
        int index = observers.indexOf(o);
        if(index>=0){
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer: observers){
            observer.updateWeatherData(windSpeed,temperature,pressure);
        }
    }

    public void setWeatherData(float windSpeed, float temperature, float pressure){
        this.windSpeed=windSpeed;
        this.temperature=temperature;
        this.pressure=pressure;
        notifyObservers();
    }


}
