package cs3343_core.meters;

public class WattMeter extends Meter {

	private double charge = 0.2;

	public WattMeter() {
		super("Wh");
	}

	public WattMeter(String unit) {
		super(unit);
	}

	public double getPrice() {
		return super.getCount() * charge;
	}
}
