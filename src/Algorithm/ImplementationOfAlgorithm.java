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
				
		return dataHolder;

	}

}
