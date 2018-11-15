package cs3343_core;

public class ResourceManager {

	private static ResourceManager instance = new ResourceManager();
	private static boolean started = false;
	private static final int ini_number_of_nodes = 5;
	private static final int ini_number_of_estates = 2;
	private static final int ini_number_of_stations = 2;

	private ResourceManager() {
	}

	public static ResourceManager getInstance() {
		return instance;
	}

	public boolean start() {
		if (started) {
			System.out.println("Resource Manager is already started!");
		} else {
			System.out.println("Starting Resource Manager (" + this.hashCode() + ").");
			System.out.println("Connected to map (" + Map.getInstance().hashCode() + ").");
			System.out.println("Initialising map...");
			Map.initialiseMap(ini_number_of_nodes, ini_number_of_estates, ini_number_of_stations);
			started = true;

			System.out.println("Printing Distance");
			Map.getInstance();
			Map.printDistances();
			System.out.println("Listing MST");
			Map.getInstance();
			Map.printMST();
		}
		return started;
	}

	public void getRoute(char from, char to) {
		Map.getInstance();
		System.out.println(Map.getRouteString(from, to));
	}
}
