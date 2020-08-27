package avajlauncher.aircrafts;

import avajlauncher.interfaces.Flyable;
import avajlauncher.aircrafts.Aircraft;
import avajlauncher.simulator.*;
import avajlauncher.messager.*;

public class Baloon extends Aircraft implements Flyable{
	
	private WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates){
		super(name, coordinates); //use super to access the parent class construtor
	}
	
	public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        int lon = this.coordinates.getLongitude();
        int lat = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        Messager messageLogger = new Messager();

        // System.out.println(lon);
        // System.out.println(lat);
        // System.out.println(height);

        if(height > 100){//max height check before
            height = 100;
        }
        
        if (weather == "SUN"){
            this.coordinates = new Coordinates(lon + 2, lat, height + 4);
            messageLogger.messager("Baloon#"+ this.name + "(" + this.id +")" + " its sunny im getting a tan");
        }else if(weather == "RAIN"){
            this.coordinates = new Coordinates(lon, lat, height - 5);
            messageLogger.messager("Baloon#"+ this.name + "(" + this.id +")" + " its Rainy out here seems like im going to swim");
        }else if(weather == "FOG"){
            this.coordinates = new Coordinates(lon, lat, height - 3);
            messageLogger.messager("Baloon#"+ this.name + "(" + this.id +")" + " its Misty out here, i cant see my hands");
        }else if(weather == "SNOW"){
            this.coordinates = new Coordinates(lon, lat, height - 15);
            messageLogger.messager("Baloon#"+ this.name + "(" + this.id +")" + " its Freezing out here, i cant feel my toes");
        }else{
            System.out.println("failed to read weather");
        }

        if(height > 100){//max height check after
            height = 100;
        }

        if(height <= 0){
            messageLogger.messager("Tower says: Baloon#"+ this.name + "(" + this.id +")" + " has landed at " + lat + " " + lon + " " + height );
            messageLogger.messager("Tower says: Baloon#"+ this.name + "(" + this.id +")" + " unregistered from weather tower" );
            this.weatherTower.unregister(this);
            //System.out.println("testing");
        }


	}
	
	public void registerTower(WeatherTower weatherTower){
        Messager messageLogger = new Messager();

        // Register (Add) this flyable to the weathertower list
        weatherTower.register(this);
		 // Register the weather tower to this flyable
         this.weatherTower = weatherTower;
         messageLogger.messager("Tower says: Baloon#"+ this.name + "(" + this.id +")" + " registered to weather tower" );
	}
}