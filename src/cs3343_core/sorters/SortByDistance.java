package cs3343_core.sorters;

import java.util.Comparator;

import cs3343_core.node.Connection;

public class SortByDistance implements Comparator<Connection> {
	public int compare(Connection a, Connection b) {
		return (int) (a.getDistance() - b.getDistance());
	}
}
