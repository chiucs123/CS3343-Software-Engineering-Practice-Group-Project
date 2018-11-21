package cs3343_core;

import java.util.*;

import cs3343_core.node.Apartments;
import cs3343_core.node.Estate;
import cs3343_core.node.Station;

public class Contacts {
	private String name = "";
	private int age = 0;
	private ArrayList<Apartments> apartments = new ArrayList<>();
	public static ArrayList<Contacts> contacts = new ArrayList<>();
	private int id = 0;

	public Contacts(String name, int age) {
		this.name = name;
		this.age = age;
		this.id = this.hashCode();
		contacts.add(this);
	}

	public static Contacts getContactByName(String name) {
		for(Contacts c : contacts) {
			if(c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return getName() + " (" + getAge() + ")";
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return getAddress(0);
	}

	public String getMultilineAddress() {
		return getMultilineAddress(0);
	}

	public String getAddress(int index) {
		if (index < getPropertyCount() && index > -1) {
			return apartments.get(index).getAddress();
		} else {
			return "Nil";
		}
	}

	public String getMultilineAddress(int index) {
		if (index < getPropertyCount() && index > -1) {
			return apartments.get(index).getMultilineAddress();
		} else {
			return "Nil";
		}
	}

	public boolean bindProperty(Apartments apartment) {
		boolean added = false;
		if (!apartments.contains(apartment)) {
			apartments.add(apartment);
			added = true;
		}
		return added;
	}

	public Apartments chooseApartment() {
		ArrayList<Estate> estates = Estate.instances;
		Estate e = estates.get((int) (Math.random() * Math.pow(10.0, (estates.size() + "").length()) % estates.size()));
		ArrayList<Integer> floor = e.getFloorList();
		int f = floor.get((int) (Math.random() * Math.pow(10.0, (floor.size() + "").length()) % floor.size()));
		ArrayList<Apartments> apartments = e.getApartmentsByFloor(f);
		Apartments a = apartments
				.get((int) (Math.random() * Math.pow(10.0, (apartments.size() + "").length()) % apartments.size()));
		if (this.bindProperty(a)) {
			e.moveIn(this);
			return a;
		} else {
			return null;
		}
	}

	public int getPropertyCount() {
		return apartments.size();
	}

	public int getID() {
		return id;
	}

	public Apartments getApartment() {
		return getApartment(0);
	}

	public Apartments getApartment(int index) {
		return apartments.get(index);
	}

	public Station checkNearestStation() {
		return checkNearestStation(0);
	}

	public Station checkNearestStation(int index) {
		return Map.determineNearestStation(apartments.get(index));
	}

	public double checkNearestStationDistance() {
		return checkNearestStationDistance(0);
	}

	public double checkNearestStationDistance(int index) {
		Station nearest = Map.determineNearestStation(apartments.get(index));
		return nearest.distanceTo(apartments.get(index).getEstate());
	}

}
