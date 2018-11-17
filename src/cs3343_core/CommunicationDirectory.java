package cs3343_core;

import java.util.*;

import cs3343_core.node.Estate;

public class CommunicationDirectory {
	private Estate owner = null;
	private ArrayList<Contacts> directory = new ArrayList<>();

	public CommunicationDirectory(Estate owner) {
		this.owner = owner;
	}

	public Contacts addToDirectory(Contacts c) {
		directory.add(c);
		Collections.sort(directory, new SortByName());
		return c;
	}

	public int getSize() {
		return directory.size();
	}

	public ArrayList<Contacts> lookup(String name) {
		ArrayList<Contacts> result = new ArrayList<>();
		for (Contacts c : directory) {
			if (c.getName().trim().toLowerCase().contains(name.trim().toLowerCase())) {
				result.add(c);
			}
		}
		return result;
	}

	public Estate getOwner() {
		return owner;
	}

	public boolean isEmpty() {
		return directory.isEmpty();
	}

	public boolean removeFrom(String name) {
		if (lookup(name).isEmpty()) {
			return false;
		} else {
			directory.remove(lookup(name).get(0));
			return true;
		}
	}
}
