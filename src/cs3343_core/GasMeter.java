package cs3343_core;

public class GasMeter extends Meter {

	private double charge = 0.8;

	public GasMeter() {
		super("m3h");
	}

	public GasMeter(String unit) {
		super(unit);
	}

	public double getPrice() {
		return super.getCount() * charge;
	}
}