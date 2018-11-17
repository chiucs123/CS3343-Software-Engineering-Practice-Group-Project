package cs3343_core.meters;

public class WaterMeter extends Meter {

	private double charge = 0.2;

	public WaterMeter() {
		super("L");
	}

	public WaterMeter(String unit) {
		super(unit);
	}

	public double getPrice() {
		return super.getCount() * charge;
	}
}
