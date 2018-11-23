package cs3343_core.node;

import java.util.ArrayList;

public class Connection {
	
	public ArrayList<Connection> instances = new ArrayList<>();
	private Node a = null;
	private Node b = null;
	private double distance = 0.0;
	private boolean enabled = true;

	public Connection(Node a, Node b) {
		this.a = a;
		this.b = b;
		this.distance = a.distanceTo(b);
		this.enabled = true;
		instances.add(this);
	}

	public boolean hasNode(Node n) {
		return n.equals(a) || n.equals(b);
	}

	public Node getNodeA() {
		return a;
	}

	public Node getNodeB() {
		return b;
	}

	public double getDistance() {
		return distance;
	}

	public boolean setState(boolean enabled) {
		this.enabled = enabled;
		return enabled;
	}

	public String toString() {
		return a.getIndex() + " <--" + String.format("%6.2f", distance) + "--> " + b.getIndex()
				+ (enabled ? "" : " (disabled)");
	}
	
//	public boolean equals(Connection c) {
//		return (this.a.equals(c.a) && this.b.equals(c.b)) || (this.a.equals(c.b) && this.b.equals(c.a));
//	}
	
}
