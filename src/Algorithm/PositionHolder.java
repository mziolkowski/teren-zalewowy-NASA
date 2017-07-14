package Algorithm;

public class PositionHolder {
	private int lat; // szerokosc geo. zr. wody
	private int lon;

	public PositionHolder(int lat, int lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	public int getLat() {
		return lat;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public int getLon() {
		return lon;
	}

	public void setLon(int lon) {
		this.lon = lon;
	}
}
