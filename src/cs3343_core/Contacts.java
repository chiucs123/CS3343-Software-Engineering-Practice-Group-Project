package cs3343_core;

import java.util.*;

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
		if (getPropertyCount() > 0) {
			return apartments.get(0).getAddress();
		} else {
			return "Nil";
		}
	}

	public String getMultilineAddress() {
		if (getPropertyCount() > 0) {
			return apartments.get(0).getMultilineAddress();
		} else {
			return "Nil";
		}
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
		ArrayList<Estate> estates = Map.getEstateList();
		Estate e = estates.get((int) (Math.random() * Math.pow(10.0, (estates.size() + "").length()) % estates.size()));
		ArrayList<Integer> floor = e.getFloorList();
		int f = floor.get((int) (Math.random() * Math.pow(10.0, (floor.size() + "").length()) % floor.size()));
		ArrayList<Apartments> apartments = e.getApartmentsByFloor(f);
		Apartments a = apartments
				.get((int) (Math.random() * Math.pow(10.0, (apartments.size() + "").length()) % apartments.size()));
		if (this.bindProperty(a)) {
			e.moveIn(this);
		}
		return a;
	}

	public int getPropertyCount() {
		return apartments.size();
	}

	public int getID() {
		return id;
	}

	public Apartments getApartment() {
		return apartments.get(0);
	}

	public Apartments getApartment(int index) {
		return apartments.get(index);
	}

	public Station checkNearestStation() {
		return Map.determineNearestStation(apartments.get(0));
	}

	public Station checkNearestStation(int index) {
		return Map.determineNearestStation(apartments.get(index));
	}

	public double checkNearestStationDistance() {
		Station nearest = Map.determineNearestStation(apartments.get(0));
		return nearest.distanceTo(apartments.get(0).getEstate());
	}

	public double checkNearestStationDistance(int index) {
		Station nearest = Map.determineNearestStation(apartments.get(index));
		return nearest.distanceTo(apartments.get(index).getEstate());
	}

}
