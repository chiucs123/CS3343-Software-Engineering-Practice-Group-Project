package cs3343_testcase.console;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.console.CmdRemoveContact;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class CmdRemoveContactTest extends TestCase {
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
		Contacts c = Contacts.add("banana", 19);
		CmdRemoveContact cmd = new CmdRemoveContact("banana");
		cmd.undo();
		assertEquals(Contacts.getContactByName("banana").getName(), "banana");
	}

	@Test
	public void testRedo() {
		Contacts c = Contacts.add("banana", 19);
		CmdRemoveContact cmd = new CmdRemoveContact("banana");
		cmd.undo();
		cmd.redo();
		assertEquals(Contacts.getContactByName("banana"), null);
	}

	@Test
	public void testCmdRemoveContact() {
		Contacts c = Contacts.add("banana", 19);
		CmdRemoveContact cmd = new CmdRemoveContact("banana");
		assertEquals(Contacts.getContactByName("banana"), null);
	}

}