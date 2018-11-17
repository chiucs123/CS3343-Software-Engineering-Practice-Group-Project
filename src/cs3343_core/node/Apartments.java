package cs3343_core.node;

import cs3343_core.Contacts;

public class Apartments {

	private Estate estate = null;
	private int floor = 0;
	private char room = 'A';

	public Apartments(Estate estate, int floor, char room) {
		this.estate = estate;
		this.floor = floor;
		this.room = room;
	}

	public String getAddress() {
		return "Rm. " + room + ", " + floor + "/F, " + estate.getName();
	}

	public String getMultilineAddress() {
		return "Rm. " + room + ", " + floor + "/F\n" + estate.getName();
	}

	public int getFloor() {
		return floor;
	}

	public Estate getEstate() {
		return estate;
	}

	public String toString() {
		return String.format("Estate Apartment %2d/F Rm.%s @ %s.", floor, room, estate.getName());
	}

	public String toCode() {
		return "" + (floor == 0 ? " G" : String.format("%2d", floor)) + room;
	}

	public boolean inhabit(Contacts c) {
		return this.estate.moveIn(c);
	}
}
