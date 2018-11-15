package cs3343_core;

public class CmdRemoveContact extends Command {

	private Contacts c = null;

	public CmdRemoveContact(String name) {
		for (Contacts ct : Contacts.contacts) {
			if (ct.getName().equals(name)) {
				c = ct;
				Contacts.contacts.remove(c);
				break;
			}
		}
	}

	@Override
	public void undo() {
		if (c != null) {
			Contacts.contacts.add(c);
		}
	}

	@Override
	public void redo() {
		if (c != null) {
			Contacts.contacts.remove(c);
		}

	}
}
