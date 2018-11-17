package cs3343_core;

import java.util.*;
import cs3343_core.node.*;
import cs3343_core.sorters.SortByDistance;

public class Map {
	private static final Map instance = new Map();
	private static boolean initialised = false;

	public static Node addNode(String type, char index) {
		switch (type) {
		case "estate":
		case "estates":
			Estate e = new Estate(index);
			return e;
		case "station":
		case "stations":
			Station s = new Station(index);
			return s;
		default:
			Node n = new Node(index);
			return n;
		}
	}

	public static Node addNode(String type, char index, double x, double y) {
		switch (type) {
		case "estate":
		case "estates":
			Estate e = new Estate(index, x, y);
			return e;
		case "station":
		case "stations":
			Station s = new Station(index, x, y);
			return s;
		default:
			Node n = new Node(index, x, y);
			return n;
		}
	}

	public static Station determineNearestStation(Apartments a) {
		double minCost = Double.POSITIVE_INFINITY;
		Station minStation = null;
		for (Station s : Station.instances) {
			double cost = getRouteNodesCost((Node) s, (Node) a.getEstate());
			if (cost < minCost) {
				minCost = cost;
				minStation = s;
			}
		}
		return minStation;
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
		for (Node n1 : Node.instances) {
			for (Node n2 : Node.instances) {
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
		return getConnectionsByNode(Node.getNodeByCode(n));
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
		ArrayList<Connection> mst = getMST();
		for (Connection c : mst) {
			if (c.hasNode(n1) && c.hasNode(n2)) {
				return c;
			}
		}
		return null;
	}

	public static ArrayList<Connection> getConnectionsByNodeAll(Node n) {
		return getConnectionsByNodeAll(n, null);
	}

	public static ArrayList<Connection> getConnectionsByNodeAll(Node n1, Node n2) {
		ArrayList<Connection> tree = getConnections();
		ArrayList<Connection> result = new ArrayList<>();
		for (Connection c : tree) {
			if (c.hasNode(n1) && (n2 == null ? true : c.hasNode(n2))) {
				result.add(c);
			}
		}
		return result;
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

	public static ArrayList<Connection> getRoute(char from, char to) {
		return getRoute(Node.getNodeByCode(from), Node.getNodeByCode(to));
	}

	public static ArrayList<Connection> getRoute(Node from, Node to) {
		ArrayList<Double> distance = new ArrayList<>();
		ArrayList<Node> parent = new ArrayList<>();
		ArrayList<Boolean> arrived = new ArrayList<>();
		ArrayList<Connection> path = new ArrayList<>();
		if (from != null && to != null) {
			for (@SuppressWarnings("unused")
			Node n : Node.instances) {
				parent.add(null);
				distance.add(Double.POSITIVE_INFINITY);
				arrived.add(false);
			}
			distance.set(Node.instances.indexOf(from), 0.0);
			arrived.set(Node.instances.indexOf(from), true);
			Node current = from;
			for (int i = 0; i < Node.instances.size(); i++) {
				ArrayList<Connection> connections = getConnectionsByNodeAll(Node.instances.get(i)); //
				Collections.sort(connections, new SortByDistance());
				double minVal = Double.POSITIVE_INFINITY;
				int minIndex = -1;
				for (Connection c : connections) {
					int index = Node.instances.indexOf(current);
					if (c.getA().equals(current)) {
						index = Node.instances.indexOf(c.getB());
					} else {
						index = Node.instances.indexOf(c.getA());
					}
					if (distance.get(index) > c.getDistance()) {
						distance.set(index, c.getDistance());
						parent.set(index, current);
						if (c.getDistance() < minVal) {
							minVal = c.getDistance();
						}
					}
				}
				for (int j = 0; j < Node.instances.size(); j++) {
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
					for (int j = 0; j < Node.instances.size(); j++) {
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
					Node next = Node.instances.get(minIndex);
					Connection matched = getConnectionsByNode(current, next);
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
		Node n1 = Node.getNodeByCode(from);
		Node n2 = Node.getNodeByCode(to);
		if (n1 == null || n2 == null) {
			return Double.POSITIVE_INFINITY;
		} else {
			return getRouteNodesCost(n1, n2);
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
		Node n1 = Node.getNodeByCode(from);
		Node n2 = Node.getNodeByCode(to);
		if (n1 == null || n2 == null) {
			return null;
		} else {
			return getRouteString(n1, n2);
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

	public static void initialiseMap(int nodes, int estates, int stations) {
		for (int i = 0; i < nodes; i++) {
			Node n = addNode("node", (char) ((int) 'a' + i));
			System.out.println("Map added [" + i + "] " + n.toString());
		}
		for (int i = 0; i < estates; i++) {
			Node e = addNode("estate", (char) ((int) 'A' + i));
			System.out.println("Map added [" + i + "] " + e.toString());
		}
		for (int i = 0; i < stations; i++) {
			Node e = addNode("stations", (char) ((int) '1' + i));
			System.out.println("Map added [" + i + "] " + e.toString());
		}
		initialised = true;
	}

	public static void printDistances() {
		if (initialised) {
			for (int i = 0; i < Node.instances.size() + 1; i++) {
				System.out.print("________");
			}
			System.out.println();

			System.out.print("______| ");
			for (Node n1 : Node.instances) {
				System.out.print(String.format("_____%c| ", n1.getIndex()));
			}
			System.out.println();

			for (Node n1 : Node.instances) {
				System.out.print(String.format("     %c| ", n1.getIndex()));
				for (Node n2 : Node.instances) {
					System.out.print(String.format("%6.2f| ", n1.distanceTo(n2)));
				}
				System.out.println();
			}

			for (int i = 0; i < Node.instances.size() + 1; i++) {
				System.out.print("________");
			}
			System.out.println();
		}
	}

	public static void printMST() {
		ArrayList<Connection> result = getMST();
		System.out.println("MST: ");
		for (Connection c : result) {
			System.out.println(c.toString());
		}
		System.out.println();
	}

	public static boolean removeNode(Node n) {
		boolean result = n.remove();
		return result;
	}

	private Map() {

	}

	public static int getCode() {
		return instance.hashCode();
	}
}
