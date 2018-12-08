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
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 1 : testContacts()");
		String name = "apple";
		int age = 18;
		Contacts c = new Contacts(name, age);
		Contacts contacts = Contacts.getContactByName(name);
		assertEquals(contacts.getName(), c.getName());
	}

	@Test
	public void testAddStringInt() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 2 : testAddStringInt()");
		String name = "apple";
		int age = 18;
		Contacts.add(name, age);
		Contacts contacts = Contacts.getContactByName(name);
		assertEquals(contacts.getName(), name);
	}

	@Test
	public void testAddContacts() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 3 : testAddContacts()");
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
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 4 : testRemoveString()");
		String name = "apple";
		int age = 18;
		Contacts c = Contacts.add(name, age);
		Contacts.remove(c.getName());
		Contacts contacts = Contacts.getContactByName(name);
		assertEquals(contacts, null);
	}

	@Test
	public void testRemoveContacts() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 5 : testRemoveContacts()");
		String name = "apple";
		int age = 18;
		Contacts c = Contacts.add(name, age);
		Contacts.remove(c);
		Contacts contacts = Contacts.getContactByName(name);
		assertEquals(contacts, null);
	}

	@Test
	public void testBindProperty() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 6 : testBindProperty()");
		fail("Not yet implemented");
	}

	@Test
	public void testChooseApartment() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 7 : testChooseApartment()");
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
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 8 : testCheckNearestStation()");
		fail("Not yet implemented");
	}

	@Test
	public void testCheckNearestStationInt() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 9 : testCheckNearestStationInt()");
		fail("Not yet implemented");
	}

	@Test
	public void testCheckNearestStationDistance() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 10 : testCheckNearestStationDistance()");
		fail("Not yet implemented");
	}

	@Test
	public void testCheckNearestStationDistanceInt() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase 11 : testCheckNearestStationDistanceInt()");
		fail("Not yet implemented");
	}

}
