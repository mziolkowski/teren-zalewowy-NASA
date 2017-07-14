package Algorithm;

public class SectorData {
	private PositionHolder min;
	private PositionHolder max;

	public SectorData(PositionHolder min, PositionHolder max) {
		super();
		this.min = min;
		this.max = max;
	}

	public PositionHolder getMin() {
		return min;
	}

	public PositionHolder getMax() {
		return max;
	}

}
