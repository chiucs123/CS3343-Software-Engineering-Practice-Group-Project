package cs3343_core.console;

import cs3343_core.Contacts;

public class CmdRemoveContact extends Command {

	private Contacts c = null;

	public CmdRemoveContact(String name) {
		c = Contacts.getContactByName(name);
		if (c != null) {
			if(Contacts.remove(name)) {
				System.out.println("Contact " + c + " removed.");
			}else {
				System.out.println("Contact " + c + " cannot be removed.");
			}
		} else {
			System.out.println("Contact " + c + " does not exist.");
		}
	}

	@Override
	public void undo() {
		if (c != null) {
			Contacts.add(c.getName(), c.getAge());
		}
	}

	@Override
	public void redo() {
		if (c != null) {
			Contacts.remove(c.getName());
		}

	}
}
