package cs3343_testcase.core;

import static org.junit.Assert.*;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.node.Apartments;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class ContactsTest extends TestCase {

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
	public void testContacts() {
		String name = "apple";
		int age = 18;

		Contacts c = new Contacts(name, age);

		Contacts contacts = Contacts.getContactByName(name);

		assertEquals(contacts.getName(), c.getName());
	}

	@Test
	public void testAddStringInt() {
		String name = "apple";
		int age = 18;

		Contacts.add(name, age);

		Contacts contacts = Contacts.getContactByName(name);

		assertEquals(contacts.getName(), name);
	}

	@Test
	public void testAddContacts() {
		String name = "apple";
		int age = 18;

		Contacts c = Contacts.add(name, age);
		
		Contacts.remove(c);
		Contacts.add(c);

		Contacts contacts = Contacts.getContactByName(name);

		assertEquals(contacts.getName(), name);
	}

	@Test
	public void testRemoveString() {
		String name = "apple";
		int age = 18;

		Contacts c = Contacts.add(name, age);
		
		Contacts.remove(c.getName());

		Contacts contacts = Contacts.getContactByName(name);

		assertEquals(contacts, null);
	}

	@Test
	public void testRemoveContacts() {
		String name = "apple";
		int age = 18;

		Contacts c = Contacts.add(name, age);
		
		Contacts.remove(c);

		Contacts contacts = Contacts.getContactByName(name);

		assertEquals(contacts, null);
	}

	@Test
	public void testBindProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testChooseApartment() {
		double positionX = 1, positionY = 0;
		char index = 'e';

		Estate e = (Estate) Map.addNode("estate", index, positionX, positionY);

		String name = "apple";
		int age = 18;

		Contacts c = Contacts.add(name, age);

		Apartments a = c.chooseApartment();

		assertEquals(a.getEstate().getName(), e.getName());
	}

	@Test
	public void testCheckNearestStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckNearestStationInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckNearestStationDistance() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckNearestStationDistanceInt() {
		fail("Not yet implemented");
	}

}
