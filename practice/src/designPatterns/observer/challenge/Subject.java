package designPatterns.observer.challenge;

import designPatterns.observer.challenge.WeatherObserver;

public interface Subject {
    public void registerObserver(WeatherObserver o);
    public void removeObserver(WeatherObserver o);
    public void notifyObservers();
}
