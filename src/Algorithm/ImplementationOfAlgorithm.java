package Algorithm;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class ImplementationOfAlgorithm {

	public DataHolder imp() throws FileNotFoundException {
		Algorithm algorithm = new Algorithm();
		DataHolder dataHolder = new DataHolder();
		
		dataHolder.setStartPosition(algorithm.getStartPosition());
		dataHolder.setWaterDirection(algorithm.getWaterDirections());
		dataHolder.setMaxMinLatLon(algorithm.maxMinLatLon());
		algorithm.startCalculation();
		dataHolder.setWaterDirection(algorithm.getWaterDirections());
		dataHolder.setCoordinateList(algorithm.getCoordinateList());

		ArrayList<Integer> coordinateList = algorithm.getCoordinateList();
		String[][] waterDirection2 = algorithm.getWaterDirections();
		
		System.out.println(" ");
		System.out.println("TABLICA WaterDirection");
		for(int m = 0; m < waterDirection2.length; m++) {
			for(int n = 0; n < waterDirection2[m].length; n++) 
				System.out.print(waterDirection2[m][n] + " ");
				System.out.println(" ");
			
		}
		
		System.out.println(" ");
		System.out.println("TABLICA CoordinateList");
		System.out.println(coordinateList);
		
		return dataHolder;

	}

}
