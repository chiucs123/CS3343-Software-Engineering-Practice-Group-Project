package cs3343_core;

public class CmdAddContact extends Command {

	private Contacts c = null;

	public CmdAddContact(String name, int age) {
		c = new Contacts(name, age);
		Contacts.contacts.add(c);
	}

	@Override
	public void undo() {
		if (c != null) {
			Contacts.contacts.remove(c);
		}
	}

	@Override
	public void redo() {
		Contacts.contacts.add(c);
	}

	public Contacts getHandlingContact() {
		return c;
	}
}
