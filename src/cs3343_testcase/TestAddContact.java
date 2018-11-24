package cs3343_testcase;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class TestAddContact extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ResourceManager.start();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		for (Node n : Node.instances)
			Map.removeNode(n);
		Contacts.reset();
	}

	@Test
	public void testAddContact() {
		String name = "apple";
		int age = 18;

		Contacts.add(name, age);

		Contacts contacts = Contacts.getContactByName(name);

		assertEquals(contacts.getName(), name);
	}

}
