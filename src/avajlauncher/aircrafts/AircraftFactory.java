package avajlauncher.aircrafts;

import avajlauncher.aircrafts.*;
import avajlauncher.interfaces.*;
import avajlauncher.simulator.*;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){//changed to static, in simulator error: connot make static reference to non static variable
        Flyable flyable = null;

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.equals("Helicopter")){
            //System.out.println("------type is helicopter--------");
            flyable = new Helicopter(name, coordinates);
        }else if (type.equals("JetPlane")){
           /// System.out.println("------type is jetplane--------");
            flyable = new JetPlane(name, coordinates);
        }else if (type.equals("Baloon")){
            //System.out.println("------type is baloon--------");
            flyable = new Baloon(name, coordinates);
        }else{
            System.out.println("aircraft not recognised " + type);
        }
        return(flyable);
    }
}