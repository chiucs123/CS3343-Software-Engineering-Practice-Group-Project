package cs3343_core;

public class BandwidthMeter extends Meter {

	private double charge = 0.1;

	public BandwidthMeter() {
		super("Mbps");
	}

	public BandwidthMeter(String unit) {
		super(unit);
	}

	public double getPrice() {
		return super.getCount() * charge;
	}
}
