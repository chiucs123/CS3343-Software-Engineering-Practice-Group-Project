package cs3343_core;

public class Meter {
	private double count = 0.0;
	private String unit = "";

	public Meter(String unit) {
		this.unit = unit;
	}

	public double getCount() {
		return count;
	}

	public double addCount(double c) {
		count += c;
		return count;
	}

	public String getUnit() {
		return unit;
	}

	public String getUnitString() {
		return "" + count + " " + unit;
	}

}
