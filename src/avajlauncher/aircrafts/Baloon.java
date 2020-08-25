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
		
	}
	
	public void registerTower(WeatherTower weatherTower){
		
	}
}