package Algorithm;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Display {
	public static void displaying(Integer[][] netMap2, Boolean[][] booleanNetMap2, String[][] waterDirection2) throws FileNotFoundException {
		
		System.out.println(" ");
		System.out.println("TABLICA netMap");
		for(int m = 0; m < netMap2.length; m++) {
			for(int n = 0; n < netMap2[m].length; n++) 
				System.out.print(netMap2[m][n] + " ");
				System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println("TABLICA BooleanNetMap");
		for(int m = 0; m < booleanNetMap2.length; m++) {
			for(int n = 0; n < booleanNetMap2[m].length; n++) 
				System.out.print(booleanNetMap2[m][n] + " ");
				System.out.println(" ");				
		}
		
		System.out.println(" ");
		System.out.println("TABLICA WaterDirection");
		for(int m = 0; m < waterDirection2.length; m++) {
			for(int n = 0; n < waterDirection2[m].length; n++) 
				System.out.print(waterDirection2[m][n] + " ");
				System.out.println(" ");
			
		}
	}

	
}
