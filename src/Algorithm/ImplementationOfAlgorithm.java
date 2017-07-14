package Algorithm;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ImplementationOfAlgorithm {

	public DataHolder imp() throws FileNotFoundException {
		Algorithm algorithm = new Algorithm();
		DataHolder dataHolder = new DataHolder();
		
		dataHolder.setStartPosition(algorithm.getStartPosition());
		dataHolder.setWetPoints(algorithm.getWetPoints());
		algorithm.startCalculation();

		ArrayList<Integer> coordinateList;
		dataHolder.setMaxMinLatLon(algorithm.maxMinLatLon());
		return dataHolder;

	}

}
