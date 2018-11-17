package cs3343_core.node;

import java.util.ArrayList;

public class Station extends Node {
	
	public static ArrayList<Station> instances = new ArrayList<>();
	private static final String type = "station";

	public Station(char index) {
		super(index);
		instances.add(this);
	}

	public Station(char index, double x, double y) {
		super(index, x, y);
		instances.add(this);
	}

	@Override
	public String getType() {
		return type;
	}
}
