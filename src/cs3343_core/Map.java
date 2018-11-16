package cs3343_core;

import java.util.*;

public class Map {
	private static final Map instance = new Map();

	public static Map getInstance() {
		return instance;
	}

	private static ArrayList<Station> stations = new ArrayList<>();
	private static ArrayList<Estate> estates = new ArrayList<>();
	private static ArrayList<Node> nodes = new ArrayList<>();

	private static boolean initialised = false;

	private Map() {

	}

	public static ArrayList<Station> getStationList() {
		return stations;
	}

	public static ArrayList<Estate> getEstateList() {
		return estates;
	}

	public static ArrayList<Node> getNodeList() {
		return nodes;
	}

	public static ArrayList<Node> getConnectedNodes(Node n) {
		ArrayList<Connection> options = getConnectionsByNode(n);
		ArrayList<Node> result = new ArrayList<>();
		for (Connection c : options) {
			if (c.getA().equals(n)) {
				result.add(c.getB());
			} else {
				result.add(c.getA());
			}
		}
		return result;
	}

	public static ArrayList<Connection> getConnections() {
		ArrayList<Connection> connections = new ArrayList<>();
		ArrayList<Node> nodesInTree = new ArrayList<>();
		for (Node n1 : nodes) {
			for (Node n2 : nodes) {
				if (n1.equals(n2)) {
					break;
				} else {
					connections.add(new Connection(n1, n2));
					nodesInTree.add(n1);
					nodesInTree.add(n2);
				}
			}
		}
		Collections.sort(connections, new SortByDistance());
		return connections;
	}

	public static ArrayList<Connection> getConnectionsByNode(char n) {
		Node node = Map.getNodeByCode(n);
		return Map.getConnectionsByNode(node);
	}

	public static ArrayList<Connection> getConnectionsByNode(Node n) {
		ArrayList<Connection> mst = getMST();
		ArrayList<Connection> result = new ArrayList<>();
		for (Connection c : mst) {
			if (c.hasNode(n)) {
				result.add(c);
			}
		}
		return result;
	}

	public static Connection getConnectionsByNode(Node n1, Node n2) {
		ArrayList<Connection> mst = Map.getMST();
		for (Connection c : mst) {
			if (c.hasNode(n1) && c.hasNode(n2)) {
				return c;
			}
		}
		return null;
	}

	public static ArrayList<Connection> getConnectionsByNodeAll(Node n) {
		ArrayList<Connection> tree = getConnections();
		ArrayList<Connection> result = new ArrayList<>();
		for (Connection c : tree) {
			if (c.hasNode(n)) {
				result.add(c);
			}
		}
		return result;
	}

	public static Connection getConnectionsByNodeAll(Node n1, Node n2) {
		ArrayList<Connection> tree = getConnections();
		for (Connection c : tree) {
			if (c.hasNode(n1) && c.hasNode(n2)) {
				return c;
			}
		}
		return null;
	}

	public static ArrayList<Connection> getMST() {
		ArrayList<Connection> connections = getConnections();
		ArrayList<Node> nodesInTree = new ArrayList<>();
		ArrayList<Connection> result = new ArrayList<>();
		for (Connection c : connections) {
			Node a = c.getA();
			Node b = c.getB();
			if (!(nodesInTree.contains(a) && nodesInTree.contains(b))) {
				result.add(c);
				nodesInTree.add(a);
				nodesInTree.add(b);
			}
		}
		Collections.sort(result, new SortByDistance());
		return result;
	}

	public static Node getNodeByCode(char code) {
		for (Node n : nodes) {
			if (n.getIndex() == code) {
				return n;
			}
		}
		return null;
	}

	public static ArrayList<Connection> getRoute(char from, char to) {
		Node n1 = Map.getNodeByCode(from);
		Node n2 = Map.getNodeByCode(to);
		if (n1 == null || n2 == null) {
			return null;
		} else {
			return Map.getRoute(n1, n2);
		}
	}

	public static ArrayList<Connection> getRoute(Node from, Node to) {
		ArrayList<Double> distance = new ArrayList<>();
		ArrayList<Node> parent = new ArrayList<>();
		ArrayList<Boolean> arrived = new ArrayList<>();
		ArrayList<Connection> path = new ArrayList<>();
		if (from != null && to != null) {
			for (@SuppressWarnings("unused")
			Node n : nodes) {
				parent.add(null);
				distance.add(Double.POSITIVE_INFINITY);
				arrived.add(false);
			}
			distance.set(nodes.indexOf(from), 0.0);
			arrived.set(nodes.indexOf(from), true);
			Node current = from;
			for (int i = 0; i < nodes.size(); i++) {
				ArrayList<Connection> connections = getConnectionsByNodeAll(nodes.get(i)); //
				Collections.sort(connections, new SortByDistance());
				double minVal = Double.POSITIVE_INFINITY;
				int minIndex = -1;
				for (Connection c : connections) {
					int index = nodes.indexOf(current);
					if (c.getA().equals(current)) {
						index = nodes.indexOf(c.getB());
					} else {
						index = nodes.indexOf(c.getA());
					}
					if (distance.get(index) > c.getDistance()) {
						distance.set(index, c.getDistance());
						parent.set(index, current);
						if (c.getDistance() < minVal) {
							minVal = c.getDistance();
						}
					}
				}
				for (int j = 0; j < nodes.size(); j++) {
					if (parent.get(j) != null && distance.get(j) > 0 && distance.get(j) == minVal && !arrived.get(j)) {
						minIndex = j;
					}
				}
				if (minIndex == -1) {
					minVal = Double.POSITIVE_INFINITY;
					for (int j = 0; j < distance.size(); j++) {
						if (distance.get(j) < minVal && !arrived.get(j)) {
							minVal = distance.get(j);
						}
					}
					for (int j = 0; j < nodes.size(); j++) {
						if (parent.get(j) != null && distance.get(j) == minVal && !arrived.get(j)) {
							minIndex = j;
						}
					}
				}

				if (current.getIndex() == to.getIndex()) {
					// System.out.println("Dijkstra found solution!");
					break;
				}

				if (minIndex > -1) {
					Node next = nodes.get(minIndex);
					Connection matched = getConnectionsByNodeAll(current, next);
					if (matched != null) {
						path.add(matched);
					}
					arrived.set(minIndex, true);
					current = next;
				} else {
					// System.out.println("Dijkstra cannot resolve further!");
					break;
				}
			}

		}
		return path;
	}

	public static ArrayList<Node> getRouteNodes(Node from, Node to) {
		ArrayList<Connection> route = getRoute(from, to);
		ArrayList<Node> result = new ArrayList<>();
		Node pointer = from;
		result.add(from);
		for (Connection c : route) {
			Node adding = (c.getA().getIndex() == pointer.getIndex() ? c.getB() : c.getA());
			if (result.contains(adding)) {

			} else {
				result.add(adding);
			}
		}
		return result;
	}

	public static double getRouteNodesCost(char from, char to) {
		Node n1 = Map.getNodeByCode(from);
		Node n2 = Map.getNodeByCode(to);
		if (n1 == null || n2 == null) {
			return Double.POSITIVE_INFINITY;
		} else {
			return Map.getRouteNodesCost(n1, n2);
		}
	}

	public static double getRouteNodesCost(Node from, Node to) {
		ArrayList<Connection> route = getRoute(from, to);
		double result = 0.0;
		for (Connection c : route) {
			result += c.getDistance();
		}
		return result;
	}

	public static String getRouteString(char from, char to) {
		Node n1 = Map.getNodeByCode(from);
		Node n2 = Map.getNodeByCode(to);
		if (n1 == null || n2 == null) {
			return null;
		} else {
			return Map.getRouteString(n1, n2);
		}
	}

	public static String getRouteString(Node from, Node to) {
		ArrayList<Node> nodes = getRouteNodes(from, to);
		String result = "" + from.getIndex() + "->" + to.getIndex() + ": ";
		boolean first = true;
		for (Node n : nodes) {
			result += (first ? "" : " -> ") + n.getIndex();
			first = false;
		}
		return result;

	}

	public static Station determineNearestStation(Apartments a) {
		double minCost = Double.POSITIVE_INFINITY;
		Station minStation = null;
		for (Station s : stations) {
			double cost = getRouteNodesCost((Node) s, (Node) a.getEstate());
			if (cost < minCost) {
				minCost = cost;
				minStation = s;
			}
		}
		return minStation;
	}

	public static void initialiseMap(int nodes, int estates, int stations) {
		for (int i = 0; i < nodes; i++) {
			Node n = addNode("station", (char) ((int) 'a' + i));
			System.out.println(String.format("Map added node %3d : %s", i, n));
		}
		for (int i = 0; i < estates; i++) {
			Node e = addNode("estate", (char) ((int) 'A' + i));
			System.out.println(String.format("Map added estate %3d : %s", i, e));
		}
		for (int i = 0; i < stations; i++) {
			Node e = addNode("stations", (char) ((int) '1' + i));
			System.out.println(String.format("Map added stations %3d : %s", i, e));
		}
		initialised = true;
	}

	public static Node addNode(String type, char index) {
		switch (type) {
		case "estate":
		case "estates":
			Estate e = new Estate(index);
			Map.estates.add(e);
			Map.nodes.add((Node) e);
			return e;
		case "station":
			Station s = new Station(index);
			Map.stations.add(s);
			Map.nodes.add((Node) s);
			return s;
		default:
			Node n = new Node(index);
			Map.nodes.add((Node) n);
			return n;
		}
	}

	public static Node addNode(String type, char index, double x, double y) {
		switch (type) {
		case "estate":
		case "estates":
			Estate e = new Estate(index, x, y);
			Map.estates.add(e);
			Map.nodes.add((Node) e);
			return e;
		case "station":
			Station s = new Station(index, x, y);
			Map.stations.add(s);
			Map.nodes.add((Node) s);
			return s;
		default:
			Node n = new Node(index, x, y);
			Map.nodes.add((Node) n);
			return n;
		}
	}

	public static boolean removeNode(Node n) {
		boolean result = true;
		switch (n.getType()) {
		case "estate":
		case "estates":
			result = result && Map.estates.remove(n);
		case "station":
			result = result && Map.stations.remove(n);
		}

		result = result && Map.nodes.remove(n);
		return result;
	}

	public static void printDistances() {
		if (initialised) {
			for (int i = 0; i < nodes.size() + 1; i++) {
				System.out.print("________");
			}
			System.out.println();

			System.out.print("______| ");
			for (Node n1 : nodes) {
				System.out.print(String.format("_____%c| ", n1.getIndex()));
			}
			System.out.println();

			for (Node n1 : nodes) {
				System.out.print(String.format("     %c| ", n1.getIndex()));
				for (Node n2 : nodes) {
					System.out.print(String.format("%6.2f| ", n1.distanceTo(n2)));
				}
				System.out.println();
			}

			for (int i = 0; i < nodes.size() + 1; i++) {
				System.out.print("________");
			}
			System.out.println();
		}
	}

	public static void printMST() {
		ArrayList<Connection> result = Map.getMST();
		System.out.println("MST: ");
		for (Connection c : result) {
			System.out.println(c.toString());
		}
		System.out.println();
	}
}
