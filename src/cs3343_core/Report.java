package cs3343_core;

import java.util.*;

import cs3343_core.node.Apartments;
import cs3343_core.node.Node;
import cs3343_core.node.Station;

public class Report {
	private static final int print_width = 120;
	private static final int print_height = 256;
	private static final boolean pagintation = true;

	public static String getDivisionLine() {
		String line = "";
		for (int i = 0; i < print_width; i++) {
			line += "-";
		}
		return line;
	}

	public static void printLine() {
		System.out.println(getDivisionLine());
	}

	public static String getSectionContact(Contacts c) {
		ArrayList<String> lines = new ArrayList<>();
		String result = "";
		lines.add(c.getName() + " - [" + c.getID() + "]");
		lines.add(c.getMultilineAddress());

		Station nearestStation = c.checkNearestStation();
		Apartments a = c.getApartment();
		lines.add("Nearest Station: " + nearestStation.getIndex() + " (" + c.checkNearestStationDistance() + ")");
		lines.add("Transit Route: " + Map.getRouteString((Node) nearestStation, (Node) a.getEstate()));

		lines.add(getDivisionLine());

		if (pagintation) {
			int pages = (int) Math.floor(((lines.size() / print_height)) + 1);
			System.out.println("Total page: " + pages + ".");
			int currentPage = 0;
			for (int pg = 0; pg < pages; pg++) {
				lines.add((currentPage * print_height + currentPage),
						String.format("%" + (print_width - 14) + "s Page %2d of %2d", "", ++currentPage, pages));
			}
		}
		result = String.join("\n", lines);
		System.out.println(result);
		return result;
	}

}
