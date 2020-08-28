package avajlauncher.simulator;

import avajlauncher.interfaces.*;
import avajlauncher.aircrafts.*;
import java.io.*;
import java.util.ArrayList;
import avajlauncher.messager.*;

public class Simulator {
	public static void main(String[] args) throws FileNotFoundException {

		// Test test1 = new Test();
		// test1.printHello(); //testing package call

		try {
            File simulation = new File("simulation.txt");
            if (simulation.createNewFile()) {
              //System.out.println("File created");
            } else {
				FileWriter fw = new FileWriter("simulation.txt");
            	PrintWriter pw = new PrintWriter(fw);
				pw.print("");										//empty file if exists
				pw.close();
            }
          } catch (Exception e) {
            System.out.println("Could not create file.");
          }

		////////// lets read from a file
		try {
			if (args.length == 0) {
				System.out.println("no file available");
				System.exit(1);
			} else {
				// System.out.println(args[0]);
				//String fileName = args[0];

				// System.out.println("File name :"+file.getName());
				// System.out.println("Path: "+file.getPath());

				BufferedReader br = null;
				br = new BufferedReader(new FileReader(args[0]));

				String line;

				int numOfSimulations = 0;

				try {
					line = br.readLine();
					numOfSimulations = Integer.parseInt(line.split(" ")[0]);// get number of simulations

					if (numOfSimulations < 0) { //check for negitives
						System.out.println("Invalid scenario file, no of simulations cannot be a negitive number");// check for negitives
						System.exit(1);
					}
					//System.out.println("no of simulations " + numOfSimulations);

				} catch (Exception e) {
					System.out.println("Invalid scenario file");
					System.exit(1);
				}

				try {

					WeatherTower tower = new WeatherTower();
					ArrayList<Flyable> flyables = new ArrayList<>();

					while ((line = br.readLine()) != null) {
						line = line.trim();
						line = line.replaceAll("\\s+", " ");
						String[] values = line.split(" ");
						if (values.length != 5) {
							System.out.println("Fields missing in scenario file");
							System.exit(1);
						}

						Flyable flyable = AircraftFactory.newAircraft( // create new aircraft
								values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]),
								Integer.parseInt(values[4]));
						flyables.add(flyable); // add new aircraft to the list of aircrafts

						// System.out.println(flyable);

						// System.out.print("Type: " + values[0]);
						// System.out.print(" Name: " + values[1]);
						// System.out.print(" Longitude: " + values[2]);
						// System.out.print(" Latitude: " + values[3]);
						// System.out.print(" Height: " + values[4]);
						// System.out.println('\n');

					}
					for (Flyable aircraft : flyables) {
						aircraft.registerTower(tower);
					}

					for (int i = 1; i <= numOfSimulations; i++) {
						tower.changeWeather();
						//System.out.println("inside weather change");
					}

					System.out.println("Simulation ran " + numOfSimulations + " times");

				} catch (Exception e) {
					System.out.println("error occured");
					System.exit(1);
				}
				br.close();
			}
		} catch (Exception e) {
			System.out.println("couldnt read from file");
			System.exit(1);
		}

	}

}