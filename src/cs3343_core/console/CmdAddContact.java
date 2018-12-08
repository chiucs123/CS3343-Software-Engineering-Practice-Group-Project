package cs3343_core.console;

import cs3343_core.Contacts;

public class CmdAddContact extends Command {

	private Contacts c = null;

	public CmdAddContact(String name, int age) {
		c = new Contacts(name, age);
	}

	@Override
	public void undo() {
		if (c != null) {
			Contacts.remove(c);
		}
	}

	@Override
	public void redo() {
		Contacts.add(c);
	}

	public Contacts getHandlingContact() {
		return c;
	}
}
