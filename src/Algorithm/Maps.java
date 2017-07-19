package Algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.geom.Angle;


public class Maps {
	
	DataSource data;
	WorldWindow wwd;
	
	public Maps(DataSource data, WorldWindow wwd) {
		super();
		this.data = data;
		this.wwd = wwd;
	}

	public static ArrayList<Double> CoordinateList() {
		ArrayList<Double> list1 = new ArrayList<Double>(16);

		list1.add(-0.001);	// wiersz
		list1.add(-0.001);	// kolumna
		
		list1.add(-0.001);
		list1.add(0.000);
		
		list1.add(-0.001);
		list1.add(0.001);
	///////////////////////////////	
		list1.add(0.000);
		list1.add(-0.001);
		
		list1.add(0.000);
		list1.add(0.001);
	///////////////////////////////	
		list1.add(0.001);
		list1.add(-0.001);
		
		list1.add(0.001);
		list1.add(0.000);
		
		list1.add(0.001);
		list1.add(0.001);
		
		return list1;
	}
	
	//Tablica przechowywujaca wsp. punktow zalanych
	protected ArrayList<Double> wetPoints() {
		ArrayList<Double> wetList = new ArrayList<Double>(16);
		return wetList;
	}
	
	//Tablica przechowywujaca zalane punkty (wartosc punktu)
	protected ArrayList<Double> listOfPoints() {
		ArrayList<Double> listOfPoints = new ArrayList<Double>(16);
		return listOfPoints;
	}
	
	
	
	public Double[][] netMap() {
		
//		Random gen = new Random();
		Double[][] netMap = new Double[data.length_tab - 1][data.width_tab - 1];
		
		for(int i = 0; i <= netMap.length - 1; i++) { 
			for(int j = 0; j <= netMap.length - 1; j++) {
				netMap[i][j] = this.wwd.getModel().getGlobe().getElevation(Angle.fromDegrees(data.slat_source + i), Angle.fromDegrees(data.slon_source + j));
			}
		}
		
		//Uzupelnienie tablicy losowymi liczbami
//		for(int i = 0; i <= netMap.length - 1; i++) { 
//			for(int j = 0; j <= netMap.length - 1; j++) {
////				netMap[i][j] = gen.nextInt(9);
//			}
//		}
		
//		netMap[data.slat][data.slon] = data.swsp_geo;
		return netMap;
	}
	
	
	protected Boolean[][] booleanNetMap() {
		Boolean[][] booleanNetMap = new Boolean[data.length_tab - 1][data.width_tab - 1];
		
		//Uzupelnienie tablicy losowymi liczbami
		for(int i = 0; i <= booleanNetMap.length - 1; i++) { 
			for(int j = 0; j <= booleanNetMap.length - 1; j++) {
				booleanNetMap[i][j] = false;
			}
		}
		return booleanNetMap;
	}
	
	
	public String[][] createWaterTab() {
			String[][] waterDirection = new String[data.length_tab - 1][data.width_tab - 1];
		
		//Uzupelnienie tablicy losowymi liczbami
		for(int i = 0; i <= waterDirection.length - 1; i++) { 
			for(int j = 0; j <= waterDirection.length - 1; j++) {
				waterDirection[i][j] = "-";
			}
		}
		return waterDirection;
	}
	
	
}