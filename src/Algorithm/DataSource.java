package Algorithm;
import java.util.Scanner;

public class DataSource {
	
	double slat; 							// szerokosc geo. zr. wody
	double slon;							// dlugosc geo. zr. wody
	double rtwsp_geo_lat;					// szerokosc geo. prawego-dolnego rogu analizowanego obszaru
	double rtwsp_geo_lon;					// dlugosc geo. prawego-dolnego rogu analizowanego obszaru
	double lbwsp_geo_lat;					// szerokosc geo. lewego-gornego rogu analizowanego obszaru
	double lbwsp_geo_lon;					// dlugosc geo. lewego-gornego rogu analizowanego obszaru
	double swsp_geo;						// wysokosc zr. wody
	int length_tab;						//dlugosc tablicy
	int width_tab;						//szerokosc tablicy
	double slatInter;
	double slonInter;	
	double lbwsp_geo_lat_source;
	double lbwsp_geo_lon_source;
	double rtwsp_geo_lat_source;
	double rtwsp_geo_lon_source;
	double slat_source;
	double slon_source;


public DataSource makeData() {
	
	Scanner scan = new Scanner(System.in);
		//Wskazanie lewego-dolnego punktu
		System.out.println("Podaj szerokosc geograficzna lewego-gornego punktu");
		lbwsp_geo_lat = scan.nextDouble();
		lbwsp_geo_lat_source = lbwsp_geo_lat;
		System.out.println("Podaj dlugosc geograficzna lewego-gornego punkty");
		lbwsp_geo_lon = scan.nextDouble();
		lbwsp_geo_lon_source = lbwsp_geo_lon;
		
		//Wskazanie prawego-gornego punktu
		System.out.println("Podaj szerokosc geograficzna prawego-dolnego punktu");
		rtwsp_geo_lat = scan.nextDouble();
		rtwsp_geo_lat_source = rtwsp_geo_lat;
		System.out.println("Podaj dlugosc geograficzna prawego-dolnego punkty");
		rtwsp_geo_lon = scan.nextDouble();
		rtwsp_geo_lon_source = rtwsp_geo_lon;
				
		//Wskazanie punktu zr. wody
		System.out.println("Podaj szerokosc geograficzna zr. wody z zakresu " + lbwsp_geo_lat + " " + rtwsp_geo_lat );
		slat = scan.nextDouble();
		slat_source = slat;
		System.out.println("Podaj dlugosc geograficzna zr. wody z zakresu " + lbwsp_geo_lon + " " + rtwsp_geo_lon);
		slon = scan.nextDouble();
		slon_source = slon;
				
		System.out.println("Podaj wysokosc zród³a wody");
		swsp_geo = scan.nextInt();
		
		
		//Okreslenie wymiaru tablicy
		if(rtwsp_geo_lat < lbwsp_geo_lat) {
			do{
				rtwsp_geo_lat += 0.001;
				length_tab = length_tab + 1;
			}while (rtwsp_geo_lat <= lbwsp_geo_lat);
			
		} else {
			do{
				lbwsp_geo_lat += 0.001;
				length_tab = length_tab + 1;
			}while (lbwsp_geo_lat <= rtwsp_geo_lat);
		}	
		
		if(rtwsp_geo_lon < lbwsp_geo_lon) {
			do{
				rtwsp_geo_lon += 0.001;
				width_tab = width_tab + 1;
			}while (rtwsp_geo_lon <= lbwsp_geo_lon);
			
		} else {
			do{
				lbwsp_geo_lon += 0.001;
				width_tab = width_tab + 1;
			}while (lbwsp_geo_lon <= rtwsp_geo_lon);
		}
		

		for(double i = slat; i <= rtwsp_geo_lat; i += 0.001) {
			slatInter++;
		}
		
		for(double j = slon; j <= rtwsp_geo_lon; j += 0.001) {
			slonInter++;
		}
		
		
		//Przesuniecie tabicy do wsp. 0,0
		lbwsp_geo_lat = 0;
		lbwsp_geo_lon = 0;
		
		rtwsp_geo_lat = lbwsp_geo_lat + width_tab;
		rtwsp_geo_lon = lbwsp_geo_lon + length_tab;
		
		slat = rtwsp_geo_lat - slatInter;
		slon = rtwsp_geo_lon - slonInter;
		
		return this;
	
	}

}
