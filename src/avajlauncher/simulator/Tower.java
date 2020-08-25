package avajlauncher.simulator;

import java.util.ArrayList;
import avajlauncher.interfaces.Flyable;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){

    }

    public void unregister(Flyable flyable){

    }

    protected void conditionsChanged(){
        
    }
}