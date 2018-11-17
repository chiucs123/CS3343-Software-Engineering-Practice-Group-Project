package cs3343_core.sorters;

import java.util.Comparator;

import cs3343_core.Contacts;

public class SortByName implements Comparator<Contacts> {
	public int compare(Contacts a, Contacts b) {
		return (a.getName().compareTo(b.getName()));
	}
}
