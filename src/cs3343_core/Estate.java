package cs3343_core;

import java.util.*;

public class Estate extends Node {
	private static final String type = "estate";
	private String[] randomNames = { "Tai", "Ho", "King", "Hoi", "Kam", "Tsin", "Fai", "Fat", "Fei", "On", "Pak", "Lau",
			"Bo", "Ease", "Wah", "Tik", "Tak", "Wan", "Wen", "Dou", "Dok", "Xin", "Mei", "Lai", "Lei", "Po", "Lean",
			"Shui", "Sum", "Fo", "Goh", "Gok", "Gay", "Sai", "Pun", "Ying", "Keung", "Li" };
	private String[] suffixName = { "Building", "Estate", "Tower", "Garden", "Complex" };
	private String name = "";
	@SuppressWarnings("unused")
	private int builtYear = 2018;
	private boolean hasLobby = (Math.random() > 0.5);
	private ArrayList<Integer> floors = new ArrayList<>();
	private ArrayList<Apartments> apartments = new ArrayList<>();
	private CommunicationDirectory cmd = new CommunicationDirectory(this);

	private void setupEstate() {

		this.name = randomNames[(int) (Math.random() * 1000 % randomNames.length)] + " "
				+ randomNames[(int) (Math.random() * 1000 % randomNames.length)] + " "
				+ suffixName[(int) (Math.random() * 1000 % suffixName.length)];
		// determine the max character of the rooms on the same floor, applied across
		// all floors.
		int max = (int) (Math.random() * 100 % 22);
		if (max == 0) {
			max = 22;
		}
		// building the estate

//		System.out.println(this.getCode());
		for (int i = (hasLobby ? 1 : 0); i < 99; i++) {
//			String log = "" + this.getCode() + " -";
			if (i % 10 == 4) {
				// skip levels with number ending 4
			} else {
				// store the floor number since not all are actually in the estate and we need
				// to know what floors are there.
				floors.add(i);
				// put the rooms there
				for (int j = 0; j < max; j++) {
					char room = (char) ((int) 'A' + j);
					Apartments a = new Apartments(this, i, room);
					apartments.add(a);
//					log += " " + a.toCode();
				}
//				System.out.println(log);
			}
			// Intentionally break estate build process if the building does not deserve to
			// be a skyscraper.
			if (Math.random() > 0.79 && i > 25) {
				break;
			}
		}
	}

	public Estate() {
		this.setupEstate();
	}

	public Estate(char index) {
		super(index);
		this.setupEstate();
	}

	public Estate(char index, double x, double y) {
		super(index, x, y);
		this.setupEstate();

	}

	public ArrayList<Integer> getFloorList() {
		return floors;
	}

	public boolean moveIn(Contacts c) {
		boolean result = false;
		if (cmd.addToDirectory(c) != null) {
			result = true;
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return this.hashCode();
	}

	public int getFloors() {
		return floors.size();
	}

	public CommunicationDirectory getCommunicationDirectory() {
		return cmd;
	}

	public char getIndex() {
		return super.getIndex();
	}

	public ArrayList<Apartments> getApartmentsByFloor(int floor) {
		ArrayList<Apartments> result = new ArrayList<>();
		if (this.floors.contains(floor)) {
			for (Apartments apartment : apartments) {
				if (apartment.getFloor() == floor) {
					result.add(apartment);
				}
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return this.hashCode() + " - " + String.format("[%6.2f , %6.2f]", this.getPositionX(), this.getPositionY())
				+ " - " + this.getName();
	}

	@Override
	public String getType() {
		return type;
	}
}
