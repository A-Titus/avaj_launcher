package avajlauncher.aircrafts;

import avajlauncher.interfaces.Flyable;
import avajlauncher.aircrafts.Aircraft;
import avajlauncher.simulator.*;

public class Baloon extends Aircraft implements Flyable{
	
	private WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates){
		super(name, coordinates); //use super to access the parent class construtor
	}
	
	public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        
        int lon = this.coordinates.getLongitude();
        int lat = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        if (weather == "SUN"){
            this.coordinates = new Coordinates(lon + 2, lat, height + 4);
            System.out.println("Baloon " + this.name + " 1" + " its sunny out here");
        }else if(weather == "RAIN"){
            this.coordinates = new Coordinates(lon, lat, height - 5);
            System.out.println("Baloon " + this.name + " 1" + " its Rainy out here");
        }else if(weather == "FOG"){
            this.coordinates = new Coordinates(lon, lat, height - 3);
            System.out.println("Baloon " + this.name + " 1" + " its Misty out here");
        }else if(weather == "SNOW"){
            this.coordinates = new Coordinates(lon, lat, height - 15);
            System.out.println("Baloon " + this.name + " 1" + " its Freezing out here");
        }else{
            System.out.println("no wether");
        }
	}
	
	public void registerTower(WeatherTower weatherTower){
		 // Register the weather tower to this flyable
         this.weatherTower = weatherTower;
         // Register (Add) this flyable to the weathertower list
         this.weatherTower.register(this);
         System.out.println("Tower says: Baloon " + this.id + " registerd to weather tower" );
	}
}