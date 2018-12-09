package cs3343_testcase.console;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.console.CmdAddContact;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

@SuppressWarnings("unused")
public class CmdAddContactTest extends TestCase {
	
	private int testIndex = 1;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ResourceManager.start();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		Node.reset();
		Contacts.reset();
	}

	@Test
	public void testUndo() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase "+(testIndex++)+" : testUndo()");
		String name = "apple";
		int age = 18;

		CmdAddContact c = new CmdAddContact(name,age);
		c.undo();
		Contacts contacts = Contacts.getContactByName(name);

		assertEquals(contacts, null);
	}

	@Test
	public void testRedo() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase "+(testIndex++)+" : testRedo()");
		String name = "apple";
		int age = 18;

		CmdAddContact c = new CmdAddContact(name,age);
		c.undo();
		c.redo();
		Contacts contacts = Contacts.getContactByName(name);

		assertEquals(contacts.getName(), name);
	}

	@Test
	public void testCmdAddContact() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase "+(testIndex++)+" : testCmdAddContact()");
		String name = "apple";
		int age = 18;

		CmdAddContact c = new CmdAddContact(name,age);

		Contacts contacts = Contacts.getContactByName(name);

		assertEquals(contacts.getName(), name);
	}

	@Test
	public void testGetHandlingContact() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase "+(testIndex++)+" : testGetHandlingContact()");
		String name = "apple";
		int age = 18;

		CmdAddContact c = new CmdAddContact(name,age);
		Contacts contacts = c.getHandlingContact();

		assertEquals(contacts.getName(), name);
	}

}
