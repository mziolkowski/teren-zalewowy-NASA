package Algorithm;


import java.util.ArrayList;


public class Algorithm extends Maps{
	
	public void Calculation(Integer[][] netMap3, ArrayList<Integer> list2, ArrayList<Integer> wetList2, Boolean[][] bolleanNetMap3, ArrayList<Integer> listOfPoints2, String[][] waterDirection2) {
		
		bolleanNetMap3[(int) slat][(int) slon] = true;
		waterDirection2[(int) slat][(int) slon] = "$";
		
		for(int i = 0; i < list2.size(); i += 2) {
			
			if(netMap3[(slat - list2.get(i))][(slon - list2.get(i + 1))] < swsp_geo) {
				
				listOfPoints2.add(netMap3[(slat - list2.get(i))][(slon - list2.get(i + 1))]);
				wetList2.add((slat - list2.get(i)));	//wps. X nowego zalanego punktu
				wetList2.add((slon - list2.get(i + 1)));	//wsp. Y nowego zalanego punktu
				bolleanNetMap3[(slat - list2.get(i))][(slon - list2.get(i + 1))] = true;
				waterDirection2[(slat - list2.get(i))][(slon - list2.get(i + 1))] = "#";
									
			} else {
				bolleanNetMap3[(slat - list2.get(i))][(slon - list2.get(i + 1))] = true;
			}
		}
		System.out.println(listOfPoints2 + " Punkty zalane");
		System.out.println(wetList2 + " Wspolrzedne X i Y zalanych punktow");
		System.out.println(" ");			
					

}

public void Calculation2(Integer[][] netMap3, ArrayList<Integer> list2, ArrayList<Integer> wetList2, Boolean[][] bolleanNetMap3, ArrayList<Integer> listOfPoints2, String[][] waterDirection2) {
	
	slat = wetList2.get(0);
	slon = wetList2.get(1);
	listOfPoints2.remove(0);
	wetList2.remove(1);
	wetList2.remove(0);

	
	for(int i = 0; i < list2.size(); i += 2) {
		try {
			if(bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] == false) {
				if(netMap3[slat - list2.get(i)][slon - list2.get(i + 1)] < swsp_geo) {
					
						listOfPoints2.add(netMap3[slat - list2.get(i)][slon - list2.get(i + 1)]);
						wetList2.add(slat - list2.get(i));
						wetList2.add(slon - list2.get(i + 1));
						bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
						waterDirection2[slat - list2.get(i)][slon - list2.get(i + 1)] = "#";
				} else {
					bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
				}
											
			} else {
				bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
			}
		}
			
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Wyszedles po za obszar!");		
			}
		}
	
	System.out.println(listOfPoints2);
	System.out.println(wetList2);
	System.out.println(" ");
	
}


}
