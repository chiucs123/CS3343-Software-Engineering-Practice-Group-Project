package cs3343_core.node;

import java.util.ArrayList;

public class Node {

	public static ArrayList<Node> instances = new ArrayList<>();
	private double posX = 0.0;
	private double posY = 0.0;
	private static final String type = "node";
	private char index = ' ';

	public Node() {
		setPosition();
		instances.add(this);
	}

	public Node(char index) {
		this.index = index;
		setPosition();
		instances.add(this);
	}

	public Node(char index, double posX, double posY) {
		this.index = index;
		setPosition(posX, posY);
		instances.add(this);
	}

	private void setPosition() {
		this.posX = Math.random() * 100 + Math.random();
		this.posY = Math.random() * 100 + Math.random();
	}

	private void setPosition(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public double getPositionX() {
		return posX;
	}

	public double getPositionY() {
		return posY;
	}

	public double distanceTo(Node another) {
		return Math.sqrt(Math.pow(Math.abs(this.getPositionX() - another.getPositionX()), 2)
				+ Math.pow(Math.abs(this.getPositionY() - another.getPositionY()), 2));
	}

	public String toString() {
		return String.format("[%7s] %12d - [%8.4f , %8.4f]", getType(), getCode(), getPositionX(), getPositionY());
	}

	public String getType() {
		return type;
	}

	public char getIndex() {
		return index;
	}

	public int getCode() {
		return this.hashCode();
	}

	public boolean remove() {
		return instances.remove(this);
	}

	public static Node getNodeByCode(char code) {
		for (Node n : instances) {
			if (n.getIndex() == code) {
				return n;
			}
		}
		return null;
	}
	
	public boolean equals(Node n) {
		return this.getIndex() == n.getIndex();
	}

	public static void reset() {
		Node.instances.clear();
		Station.instances.clear();
		Estate.instances.clear();
		Apartments.instances.clear();
	}
}
