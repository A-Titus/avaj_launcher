package avajlauncher.aircrafts;

import avajlauncher.interfaces.Flyable;
import avajlauncher.aircrafts.Aircraft;
import avajlauncher.simulator.*;
import avajlauncher.messager.*;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates); // use super to access the parent class construtor
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);

        int lon = this.coordinates.getLongitude();
        int lat = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        Messager messageLogger = new Messager();

        if(height > 100){//max height check before
            height = 100;
        }

        if (weather == "SUN") {
            this.coordinates = new Coordinates(lon, lat + 10, height + 2);
            messageLogger.messager("JetPlane#"+ this.name + "(" + this.id +")" + " its Sunny out here, beautiful day");
        } else if (weather == "RAIN") {
            this.coordinates = new Coordinates(lon, lat + 5, height);
            messageLogger.messager("JetPlane#"+ this.name + "(" + this.id +")" + " its Rainy out here, i want the sun back");
        } else if (weather == "FOG") {
            this.coordinates = new Coordinates(lon, lat + 1, height);
            messageLogger.messager("JetPlane#"+ this.name + "(" + this.id +")" + " its Misty out here, were flying blind");
        } else if (weather == "SNOW") {
            this.coordinates = new Coordinates(lon, lat, height - 7);
            messageLogger.messager("JetPlane#"+ this.name + "(" + this.id +")" + " its Freezing out here, i cant feel my hands");
        } else {
            System.out.println("no weather");
        }

        if(height > 100){//max height check after
            height = 100;
        }

        if(height <= 0){
            messageLogger.messager("Tower says: JetPlane#"+ this.name + "(" + this.id +")" + " has landed at " + lat + " " + lon + " " + height );
            messageLogger.messager("Tower says: JetPlane#"+ this.name + "(" + this.id +")" + " unregistered from weather tower" );
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        Messager messageLogger = new Messager();

        // Register (Add) this flyable to the weathertower list
        weatherTower.register(this);
        // Register the weather tower to this flyable
        this.weatherTower = weatherTower;
        messageLogger.messager("Tower says: JetPlane#"+ this.name + "(" + this.id +")" + " registered to weather tower");
    }

}
