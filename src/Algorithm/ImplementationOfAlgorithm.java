package Algorithm;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ImplementationOfAlgorithm extends Display{
	public static void main(String[] args) throws FileNotFoundException {
		
		Display disp= new Display();
		
		Integer[][] netMap3 = disp.NetMap();
		ArrayList<Integer> list2 = disp.CoordinateList();
		ArrayList<Integer> wetList2 = disp.WetPoints();
		Boolean[][] bolleanNetMap3 = disp.BooleanNetMap();
		ArrayList<Integer> listOfPoints2 = disp.ListOfPoints();
		String[][] waterDirection2 = disp.WaterDirection();
		
		
		disp.Calculation(netMap3, list2, wetList2, bolleanNetMap3, listOfPoints2, waterDirection2);
		do {
		disp.Calculation2(netMap3, list2, wetList2, bolleanNetMap3, listOfPoints2, waterDirection2);
		}while(listOfPoints2.isEmpty() == false && wetList2.isEmpty() == false);
		
		disp.Displaying(netMap3, bolleanNetMap3, waterDirection2);
				
	}
		

}
