package avajlauncher.simulator;

import avajlauncher.aircrafts.*;

public class WeatherProvider {
    private WeatherProvider weatherProvider;
    private String weather[];

    private WeatherProvider(){

    }

    public WeatherProvider getProvider(){
        //
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        //
        return weather[0];
    }
}