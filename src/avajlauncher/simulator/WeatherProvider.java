package avajlauncher.simulator;

import avajlauncher.aircrafts.*;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){

    }

    public static WeatherProvider getProvider(){
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        //
        int point = coordinates.getHeight();
        if(point > 0 && point <= 25){
            point = 0;
        }else if(point > 25 && point <= 50){
            point = 1;
        }else if(point > 50 && point <= 75){
            point = 2;
        }else if(point > 75 && point <= 100){
            point = 3;
        }
        return weather[point];
    }
}