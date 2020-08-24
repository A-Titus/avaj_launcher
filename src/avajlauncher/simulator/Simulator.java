package avajlauncher.simulator;

import avajlauncher.test.*;
import java.io.*;

public class Simulator{
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("hello world`");
		
		//Test test1 = new Test();
			//test1.printHello(); //testing package call
			
	//////////lets read from a file
	 if (args.length == 0){
			System.out.print("no file available");
			return;
        }else{
			//System.out.println(args[0]);
			String fileName = args[0];
			
			
			//System.out.println("File name :"+file.getName()); 
			//System.out.println("Path: "+file.getPath()); 
			
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(args[0]));
			
			String line;
			
			int numOfSimulations = 0;
			
			try {
					line = br.readLine();
					numOfSimulations = Integer.parseInt(line.split(" ")[0]);//get number of simulations
					System.out.println("no of simulations " + numOfSimulations);
					
			}catch (Exception e){
					System.out.println(e);
				}
			
			try{ 
					while((line = br.readLine()) != null){
					
					System.out.print(line.split(" ")[0]);
					System.out.print(line.split(" ")[1]);
					System.out.print(line.split(" ")[2]);
					System.out.print(line.split(" ")[3]);
					System.out.print(line.split(" ")[4]);
					System.out.println('\n');
					
				}
			}catch (IOException e){
				System.out.println(e);
			}
			
			
			
			
		}
	
	}
	
}