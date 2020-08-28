package avajlauncher.simulator;

import java.util.*;
import avajlauncher.interfaces.Flyable;

public abstract class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        try {
            this.observers.add(flyable);     
        } catch (Exception e) {
            System.out.println("failed to register flyable");
        }
    }

    public void unregister(Flyable flyable){
        try {
       this.observers.remove(flyable);    
        } catch (Exception e) {
            System.out.println("failed to unregister");
        }
  
    }

    protected void conditionsChanged(){
        try {
            for(int i = 0; i < observers.size(); i++)
            {
                observers.get(i).updateConditions();
            } 
        } catch (Exception e) {
            System.out.println("failed to update conditions");        }
        }
        //System.out.println("in tower conditions change method");
        // try {
            // for (Flyable flyable : observers) {
            //     flyable.updateConditions();
            //    // System.out.println("after tower conditions change method"); concurrent modificationerror
            // }
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
        //     }

}