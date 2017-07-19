package Algorithm;

public class PositionHolder {
	private double lat; 
	private double lon;

	public PositionHolder(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(int lon) {
		this.lon = lon;
	}
}