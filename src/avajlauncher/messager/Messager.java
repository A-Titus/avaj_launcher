package avajlauncher.messager;

import java.io.FileWriter;

public class Messager {
   public void messager(String message){
        try {
            FileWriter messageLogger = new FileWriter("simulation.txt");
            messageLogger.write(message);
            messageLogger.close();
          } catch (Exception e) {
            System.out.println("Could not write to file.");
          }
    }
}