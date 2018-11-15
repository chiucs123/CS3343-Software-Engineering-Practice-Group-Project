package cs3343_core;

import java.util.Comparator;

public class SortByName implements Comparator<Contacts> {
	public int compare(Contacts a, Contacts b) {
		return (a.getName().compareTo(b.getName()));
	}
}
