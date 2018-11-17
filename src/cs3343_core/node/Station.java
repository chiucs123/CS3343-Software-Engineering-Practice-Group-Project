package cs3343_core.node;

public class Station extends Node {
	private static final String type = "station";

	public Station(char index) {
		super(index);
	}

	public Station(char index, double x, double y) {
		super(index, x, y);
	}

	@Override
	public String getType() {
		return type;
	}
}
