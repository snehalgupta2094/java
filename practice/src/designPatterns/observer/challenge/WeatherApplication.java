package designPatterns.observer.challenge;

public class WeatherApplication {

    public static void main(String[] args) {
        WeatherStation weatherStation=new WeatherStation();
        Logger logger=new Logger(weatherStation);
        UserInterface userInterface=new UserInterface(weatherStation);
        AlertSystem alertSystem=new AlertSystem(weatherStation);
        weatherStation.setWeatherData(100f,120f,230f);
        logger.log();
        weatherStation.setWeatherData(200f,220f,430f);
        userInterface.display();
        alertSystem.alert();
        logger.log();
    }
}
