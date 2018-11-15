package cs3343_core;

import java.util.Comparator;

public class SortByDistance implements Comparator<Connection> {
	public int compare(Connection a, Connection b) {
		return (int) (a.getDistance() - b.getDistance());
	}
}
