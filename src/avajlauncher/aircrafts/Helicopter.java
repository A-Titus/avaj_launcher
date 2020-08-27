package avajlauncher.aircrafts;

import avajlauncher.interfaces.Flyable;
import avajlauncher.aircrafts.Aircraft;
import avajlauncher.simulator.*;
import avajlauncher.messager.*;

public class Helicopter extends Aircraft implements Flyable{
	
	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates){
		super(name, coordinates); //use super to access the parent class construtor
	}
	
	public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        
        int lon = this.coordinates.getLongitude();
        int lat = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        Messager messageLogger = new Messager();

        if(height > 100){//max height check before
            height = 100;
        }

        if (weather == "SUN"){
            this.coordinates = new Coordinates(lon + 10, lat, height + 2);
            messageLogger.messager("Helicopter#"+ this.name + "(" + this.id +")" + " its Sunny out here, wheres my sunglasses");
        }else if(weather == "RAIN"){
            this.coordinates = new Coordinates(lon + 5, lat, height);
            messageLogger.messager("Helicopter#"+ this.name + "(" + this.id +")" + " its Rainy out here, weve got to land soon");
        }else if(weather == "FOG"){
            this.coordinates = new Coordinates(lon + 1, lat, height);
            messageLogger.messager("Helicopter#"+ this.name + "(" + this.id +")" + " its Misty out here, hold on tight i cant see!");
        }else if(weather == "SNOW"){
            this.coordinates = new Coordinates(lon, lat, height - 12);
            messageLogger.messager("Helicopter#"+ this.name + "(" + this.id +")" + " its Freezing out here, where are my feet i cant feel them");
        }else{
            System.out.println("no weather");
        }

        if(height > 100){//max height check after
            height = 100;
        }

        if(height <= 0){
            messageLogger.messager("Tower says: Helicopter#"+ this.name + "(" + this.id +")" + " has landed at " + lat + " " + lon + " " + height );
            messageLogger.messager("Tower says: Helicopter#"+ this.name + "(" + this.id +")" + " unregistered from weather tower" );
            this.weatherTower.unregister(this);
        }
	}
	
	public void registerTower(WeatherTower weatherTower){
        Messager messageLogger = new Messager();

         this.weatherTower = weatherTower;
         this.weatherTower.register(this);
         messageLogger.messager("Tower says: Helicopter#"+ this.name + "(" + this.id +")" + " registered to weather tower" );
	}
}
