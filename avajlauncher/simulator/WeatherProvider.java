package avajlauncher.simulator;

import avajlauncher.aircrafts.*;
import java.util.Random;

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
        int rand = new Random().nextInt(4);

        return (weather[rand]);
        // int point = coordinates.getHeight();
        // if(point > 0 && point <= 25){
        //     point = 0;
        // }else if(point > 25 && point <= 50){
        //     point = 1;
        // }else if(point > 50 && point <= 75){
        //     point = 2;
        // }else if(point > 75 && point <= 100){
        //     point = 3;
        // }
        // return weather[point];
    }
}