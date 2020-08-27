package avajlauncher.simulator;

import java.util.ArrayList;
import avajlauncher.interfaces.Flyable;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        try {
            this.observers.add(flyable);     
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void unregister(Flyable flyable){
        try {
            this.observers.remove(flyable);     
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void conditionsChanged(){
        try {
            for (Flyable flyable : observers) {
                flyable.updateConditions();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
            }
}