package cs3343_core;

public class Node {
	protected double posX = 0.0;
	protected double posY = 0.0;
	private static final String type = "node";
	private char index = ' ';

	public Node() {
		this.posX = Math.random() * 100 + Math.random();
		this.posY = Math.random() * 100 + Math.random();
	}

	public Node(char index) {
		this.index = index;
		this.posX = Math.random() * 100 + Math.random();
		this.posY = Math.random() * 100 + Math.random();
	}

	public Node(char index, double posX, double posY) {
		this.index = index;
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
		return String.format("[%s] %12d - [%6.2f , %6.2f]", getType(), hashCode(), getPositionX(), getPositionY());
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
}
