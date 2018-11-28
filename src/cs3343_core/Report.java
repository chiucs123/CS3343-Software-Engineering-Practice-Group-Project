package cs3343_core;

import java.util.*;

import cs3343_core.node.*;
import cs3343_core.resources.*;

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

	public static String getSectionUsage(Contacts c) {
		ArrayList<String> lines = new ArrayList<>();
		String result = "";

		lines.add("Usage Charges:");
		lines.add(String.format("%10s : %8.4f %2s", Water.type, Resource.getUsage(), "L"));
		lines.add(String.format("%10s : %8.4f %2s", Network.type, Resource.getUsage(), "MB"));
		lines.add(String.format("%10s : %8.4f %2s", Gas.type, Resource.getUsage(), "m3"));
		lines.add(String.format("%10s : %8.4f %2s", Electricity.type, Resource.getUsage(),"kW"));

		lines.add("");
		lines.add("Path Charges:");
		Station nearestStation = c.checkNearestStation();
		Apartments a = c.getApartment();
		Node from = nearestStation;
		Node to = a.getEstate();
		ArrayList<Node> route = Map.getRouteNodes(from, to);
		double total = 0.0;
		for (int i = 0; i < route.size() - 2; i++) {
			Node sfrom = route.get(i);
			Node sto = route.get(i + 1);
			double sectionCharge = Map.getRouteNodesCost(sfrom, sto);
			total += sectionCharge;
			lines.add(String.format("%c -> %c : %8.4f", sfrom.getIndex(), sto.getIndex(), sectionCharge));
		}
		lines.add("--------------------------");
		lines.add(String.format("       : %8.4f", total));

		lines.add("");
		lines.add(getDivisionLine());

		result = String.join("\n", lines);
		System.out.println(result);
		return result;
	}

}
