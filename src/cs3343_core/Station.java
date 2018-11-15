package cs3343_core;

public class Station extends Node {
	private static final String type = "station";

	public Station(char index) {
		super(index);
	}

	public Station(char index, double x, double y) {
		super(index, x, y);
	}

	public char getIndex() {
		return super.getIndex();
	}

	@Override
	public String toString() {
		return String.format("%12d - [%6.2f , %6.2f]", this.hashCode(), this.getPositionX(), this.getPositionY());
	}

	@Override
	public String getType() {
		return type;
	}
}
