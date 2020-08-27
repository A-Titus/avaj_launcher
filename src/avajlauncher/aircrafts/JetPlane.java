package avajlauncher.aircrafts;

import avajlauncher.interfaces.Flyable;
import avajlauncher.aircrafts.Aircraft;
import avajlauncher.simulator.*;

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

        if (weather == "SUN") {
            this.coordinates = new Coordinates(lon, lat + 10, height + 2);
            System.out.println("JetPlane " + this.name + " "+this.id + " its sunny out here");
        } else if (weather == "RAIN") {
            this.coordinates = new Coordinates(lon, lat + 5, height);
            System.out.println("JetPlane " + this.name + " "+this.id + " its Rainy out here");
        } else if (weather == "FOG") {
            this.coordinates = new Coordinates(lon, lat + 1, height);
            System.out.println("JetPlane " + this.name + " "+this.id + " its Misty out here");
        } else if (weather == "SNOW") {
            this.coordinates = new Coordinates(lon, lat, height - 7);
            System.out.println("JetPlane " + this.name + " "+this.id + " its Freezing out here");
        } else {
            System.out.println("no wether");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        // Register (Add) this flyable to the weathertower list
        weatherTower.register(this);
        // Register the weather tower to this flyable
        this.weatherTower = weatherTower;
        System.out.println("Tower says: JetPlane#"+ this.name + "(" + this.id +")" + " registered to weather tower");
    }

}
