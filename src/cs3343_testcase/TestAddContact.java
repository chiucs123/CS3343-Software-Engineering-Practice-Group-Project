package cs3343_testcase;

import org.junit.Test;

import cs3343_core.Contacts;
import junit.framework.TestCase;

public class TestAddContact extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testAddContact() {
		String name = "apple";
		int age = 18;
		
		Contacts.add(name, age);
		
		Contacts contacts = Contacts.getContactByName(name);
		
		assertEquals(contacts.getName(), name);
		
		Contacts.remove(contacts);
	}
	
	
}
