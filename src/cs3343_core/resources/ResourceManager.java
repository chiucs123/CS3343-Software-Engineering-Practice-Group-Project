package cs3343_core.resources;

import cs3343_core.Map;

public class ResourceManager {

	private static final ResourceManager instance = new ResourceManager();
	private static boolean started = false;
	private static boolean debug = false;
	private static final int ini_number_of_nodes = 0;
	private static final int ini_number_of_estates = 0;
	private static final int ini_number_of_stations = 0;

	private ResourceManager() {
	}

	public static boolean start() {
		if (started) {
			if (debug) {
				System.out.println("Resource Manager is already started!");
			}
		} else {
			if (debug) {
				System.out.println("Starting Resource Manager (" + instance.hashCode() + ").");
				System.out.println("Connected to map (" + Map.getCode() + ").");
				System.out.println("Initialising map...");
			}
			Map.initialiseMap(ini_number_of_nodes, ini_number_of_estates, ini_number_of_stations);
			started = true;
		}
		return started;
	}
	
	public static boolean isStarted() {
		return started;
	}

	public static void getRoute(char from, char to) {
		System.out.println(Map.getRouteString(from, to));
	}
}
