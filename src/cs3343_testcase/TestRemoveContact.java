package cs3343_testcase;

import org.junit.Test;

import cs3343_core.Contacts;
import junit.framework.TestCase;

public class TestRemoveContact extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testRemoveContactsSuccess() {
		String name = "apple";
		int age = 18;

		Contacts.add(name, age);

		Contacts contacts = Contacts.getContactByName(name);

		boolean removeSuccess = Contacts.remove(contacts);

		assertEquals(removeSuccess, true);
	}

	@Test
	public void testRemoveContactsFail() {
		String name = "apple";
		int age = 18;

		Contacts contacts = new Contacts(name, age);

		boolean removeSuccess = Contacts.remove(contacts);

		assertEquals(removeSuccess, false);
	}
}
