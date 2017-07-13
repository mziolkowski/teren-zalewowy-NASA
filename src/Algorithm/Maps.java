package Algorithm;
import java.util.ArrayList;
import java.util.Random;


public class Maps extends DataSource{
	
	protected ArrayList<Integer> CoordinateList() {
		ArrayList<Integer> list1 = new ArrayList<Integer>(16);
		list1.add(-1);	// wiersz
		list1.add(-1);	// kolumna
		
		list1.add(-1);
		list1.add(0);
		
		list1.add(-1);
		list1.add(1);
	///////////////////////////////	
		list1.add(0);
		list1.add(-1);
		
		list1.add(0);
		list1.add(1);
	///////////////////////////////	
		list1.add(1);
		list1.add(-1);
		
		list1.add(1);
		list1.add(0);
		
		list1.add(1);
		list1.add(1);
		
		return list1;
	}
	
	//Tablica przechowywujaca wsp. punktow zalanych
	protected ArrayList<Integer> WetPoints() {
		ArrayList<Integer> wetList = new ArrayList<Integer>(16);
		return wetList;
	}
	
	//Tablica przechowywujaca zalane punkty (wartosc punktu)
	protected ArrayList<Integer> ListOfPoints() {
		ArrayList<Integer> listOfPoints = new ArrayList<Integer>(16);
		return listOfPoints;
	}
	
	
	
	protected Integer[][] NetMap() {
		Random gen = new Random();
		Integer[][] netMap = new Integer[length_tab - 1][width_tab - 1];
		
		//Uzupelnienie tablicy losowymi liczbami
		for(int i = 0; i <= netMap.length - 1; i++) { 
			for(int j = 0; j <= netMap.length - 1; j++) {
				netMap[i][j] = gen.nextInt(9);
			}
		}
		
		netMap[slat][slon] = swsp_geo;
		return netMap;
	}
	
	
	protected Boolean[][] BooleanNetMap() {
		Boolean[][] booleanNetMap = new Boolean[length_tab - 1][width_tab - 1];
		
		//Uzupelnienie tablicy losowymi liczbami
		for(int i = 0; i <= booleanNetMap.length - 1; i++) { 
			for(int j = 0; j <= booleanNetMap.length - 1; j++) {
				booleanNetMap[i][j] = false;
			}
		}
		return booleanNetMap;
	}
	
	
	protected String[][] WaterDirection() {
			String[][] waterDirection = new String[length_tab - 1][width_tab - 1];
		
		//Uzupelnienie tablicy losowymi liczbami
		for(int i = 0; i <= waterDirection.length - 1; i++) { 
			for(int j = 0; j <= waterDirection.length - 1; j++) {
				waterDirection[i][j] = "-";
			}
		}
		return waterDirection;
	}
	
	
}
