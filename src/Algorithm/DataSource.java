package Algorithm;
import java.util.Scanner;

public class DataSource {
	
	private double waterPointLat; 							// szerokosc geo. zr. wody
	private double waterPointLon;							// dlugosc geo. zr. wody
	private double rightTopPointLat;						// szerokosc geo. prawego-górngo rogu analizowanego obszaru
	private double rightTopPointLon;						// dlugosc geo. prawego-górnego rogu analizowanego obszaru
	private double leftBottomPointLat;						// szerokosc geo. lewego-dolnego rogu analizowanego obszaru
	private double leftBottomPointLon;						// dlugosc geo. lewego-dolnego rogu analizowanego obszaru
	private double sourceWaterHeight;						// wysokosc zr. wody
	private int lengthTab;									// dlugosc tablicy
	private int widthTab;									// szerokosc tablicy
	private double slatIteration;							// licznik s³u¿¹cy do przeuniêcia punktów tablicy
	private double slonIteration;							// licznik s³u¿¹cy do przeuniêcia punktów tablicy
	private double leftBottomPointLatSource;				// szerokosc geo. lewego-dolnego rogu analizowanego obszaru zgodna z mapa
	private double leftBottomPointLonSource;				// dlugosc geo. lewego-dolnego rogu analizowanego obszaru zgodna z mapa
	private double rightTopPointLatSource;					// szerokosc geo. prawego-górngo rogu analizowanego obszaru zgodna z mapa
	private double rightTopPointLonSource;					// dlugosc geo. prawego-górnego rogu analizowanego obszaru zgodna z mapa
	private double waterSourcePointLat;						// szerokosc geo. zr. wody zgodna z mapa
	private double waterSourcePointLon;						// dlugosc geo. zr. wody zgodna z mapa
	private double minGeoLat;								// min. wartosc szerokosci obszaru
	private double maxGeoLat;								// max. wartosc szerokosci obszaru
	private double minGeoLon;								// min. wartosc d³ugosci obszaru
	private double maxGeoLon;								// max. wartosc d³ugosci obszaru


public DataSource makeData() {
	
	Scanner scan = new Scanner(System.in);
		//Wskazanie lewego-dolnego punktu
		System.out.println("Podaj szerokosc geograficzna lewego-dolnego punktu");
		leftBottomPointLat = scan.nextDouble();
		setLeftBottomPointLatSource(leftBottomPointLat);
		System.out.println("Podaj dlugosc geograficzna lewego-dolnego punkty");
		leftBottomPointLon = scan.nextDouble();
		setLeftBottomPointLonSource(leftBottomPointLon);
		
//		//Wskazanie prawego-gornego punktu
		System.out.println("Podaj szerokosc geograficzna prawego-gÃ³rnego punktu");
		rightTopPointLat = scan.nextDouble();
		setRightTopPointLatSource(rightTopPointLat);
		System.out.println("Podaj dlugosc geograficzna prawego-gÃ³rnego punkty");
		rightTopPointLon = scan.nextDouble();
		setRightTopPointLonSource(rightTopPointLon);
				
//		//Wskazanie punktu zr. wody
		System.out.println("Podaj szerokosc geograficzna zr. wody z zakresu " + leftBottomPointLat + " " + rightTopPointLat );
		setWaterPointLat(scan.nextDouble());
		setWaterSourcePointLat(getWaterPointLat());
		System.out.println("Podaj dlugosc geograficzna zr. wody z zakresu " + leftBottomPointLon + " " + rightTopPointLon);
		setWaterPointLon(scan.nextDouble());
		setWaterSourcePointLon(getWaterPointLon());
//				
		System.out.println("Podaj wysokosc zrï¿½dï¿½a wody");
		setSourceWaterHeight(scan.nextInt());
		
		
		//Okreslenie wymiaru tablicy
		if(rightTopPointLat < leftBottomPointLat) {
			do{
				rightTopPointLat += 0.001;
				setLengthTab(getLengthTab() + 1);
			}while (rightTopPointLat <= leftBottomPointLat);
			
		} else {
			do{
				leftBottomPointLat += 0.001;
				setLengthTab(getLengthTab() + 1);
			}while (leftBottomPointLat <= rightTopPointLat);
		}	
		
		if(rightTopPointLon < leftBottomPointLon) {
			do{
				rightTopPointLon += 0.001;
				setWidthTab(getWidthTab() + 1);
			}while (rightTopPointLon <= leftBottomPointLon);
			
		} else {
			do{
				leftBottomPointLon += 0.001;
				setWidthTab(getWidthTab() + 1);
			}while (leftBottomPointLon <= rightTopPointLon);
		}
		

		for(double i = getWaterPointLat(); i <= rightTopPointLat; i += 0.001) {
			slatIteration++;
		}
		
		for(double j = getWaterPointLon(); j <= rightTopPointLon; j += 0.001) {
			slonIteration++;
		}
		
		
		//Przesuniecie tabicy do wsp. 0,0
		leftBottomPointLat = 0;
		leftBottomPointLon = 0;
		
		rightTopPointLat = leftBottomPointLat + getWidthTab();
		rightTopPointLon = leftBottomPointLon + getLengthTab();
		
		setWaterPointLat(rightTopPointLat - slatIteration);
		setWaterPointLon(rightTopPointLon - slonIteration);
		
		if (getRightTopPointLatSource() > getLeftBottomPointLatSource()) {
			maxGeoLat = getRightTopPointLatSource();
			setMinGeoLat(getLeftBottomPointLatSource());
		} else {
			maxGeoLat = getLeftBottomPointLatSource();
			setMinGeoLat(getRightTopPointLatSource());
		}

		if (getRightTopPointLonSource() > getLeftBottomPointLonSource()) {
			maxGeoLon = getRightTopPointLonSource();
			setMinGeoLon(getLeftBottomPointLonSource());
		} else {
			maxGeoLon = getLeftBottomPointLonSource();
			setMinGeoLon(getRightTopPointLonSource());
		}
		
		return this;
	
	}


public double getWaterPointLat() {
	return waterPointLat;
}


public void setWaterPointLat(double waterPointLat) {
	this.waterPointLat = waterPointLat;
}


public double getWaterPointLon() {
	return waterPointLon;
}


public void setWaterPointLon(double waterPointLon) {
	this.waterPointLon = waterPointLon;
}


public int getLengthTab() {
	return lengthTab;
}


public void setLengthTab(int lengthTab) {
	this.lengthTab = lengthTab;
}


public int getWidthTab() {
	return widthTab;
}


public void setWidthTab(int widthTab) {
	this.widthTab = widthTab;
}


public double getWaterSourcePointLat() {
	return waterSourcePointLat;
}


public void setWaterSourcePointLat(double waterSourcePointLat) {
	this.waterSourcePointLat = waterSourcePointLat;
}


public double getWaterSourcePointLon() {
	return waterSourcePointLon;
}


public void setWaterSourcePointLon(double waterSourcePointLon) {
	this.waterSourcePointLon = waterSourcePointLon;
}


public double getSourceWaterHeight() {
	return sourceWaterHeight;
}


public void setSourceWaterHeight(double sourceWaterHeight) {
	this.sourceWaterHeight = sourceWaterHeight;
}


public double getMinGeoLon() {
	return minGeoLon;
}


public void setMinGeoLon(double minGeoLon) {
	this.minGeoLon = minGeoLon;
}


public double getMinGeoLat() {
	return minGeoLat;
}


public void setMinGeoLat(double minGeoLat) {
	this.minGeoLat = minGeoLat;
}


public double getRightTopPointLatSource() {
	return rightTopPointLatSource;
}


public void setRightTopPointLatSource(double rightTopPointLatSource) {
	this.rightTopPointLatSource = rightTopPointLatSource;
}


public double getLeftBottomPointLatSource() {
	return leftBottomPointLatSource;
}


public void setLeftBottomPointLatSource(double leftBottomPointLatSource) {
	this.leftBottomPointLatSource = leftBottomPointLatSource;
}


public double getRightTopPointLonSource() {
	return rightTopPointLonSource;
}


public void setRightTopPointLonSource(double rightTopPointLonSource) {
	this.rightTopPointLonSource = rightTopPointLonSource;
}


public double getLeftBottomPointLonSource() {
	return leftBottomPointLonSource;
}


public void setLeftBottomPointLonSource(double leftBottomPointLonSource) {
	this.leftBottomPointLonSource = leftBottomPointLonSource;
}



}
