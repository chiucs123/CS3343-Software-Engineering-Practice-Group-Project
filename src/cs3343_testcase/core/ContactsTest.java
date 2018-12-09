package cs3343_testcase.core;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.node.Apartments;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.node.Station;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

@SuppressWarnings("unused")
public class ContactsTest extends TestCase {

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
	public void testContacts() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testContacts()");
		String name = "apple";
		int age = 18;
		Contacts c = new Contacts(name, age);
		Contacts contacts = Contacts.getContactByName(name);
		assertEquals(contacts.getName(), c.getName());
	}

	@Test
	public void testAddStringInt() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testAddStringInt()");
		String name = "apple";
		int age = 18;
		Contacts.add(name, age);
		Contacts contacts = Contacts.getContactByName(name);
		assertEquals(contacts.getName(), name);
	}

	@Test
	public void testAddContacts() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testAddContacts()");
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
		System.out.println("Testcase " + (testIndex++) + " : testRemoveString()");
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
		System.out.println("Testcase " + (testIndex++) + " : testRemoveContacts()");
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
		System.out.println("Testcase " + (testIndex++) + " : testBindProperty()");

		Estate s = new Estate('s', 1, 0);
		Apartments a = new Apartments(s, 1, 'A');

		String name = "apple";
		int age = 18;
		Contacts c = Contacts.add(name, age);
		c.bindProperty(a);
		assertEquals(c.getApartment(), a);
	}

	@Test
	public void testChooseApartment() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testChooseApartment()");
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
		System.out.println("Testcase " + (testIndex++) + " : testCheckNearestStation()");

		double positionX = 1, positionY = 0;
		char index = 'e';

		Estate e = (Estate) Map.addNode("estate", index, positionX, positionY);
		Station s = (Station) Map.addNode("station", 's', 3, 0);

		String name = "apple";
		int age = 18;

		Contacts c = Contacts.add(name, age);
		Apartments a = c.chooseApartment();
		c.bindProperty(a);

		Station st = c.checkNearestStation();

		System.out.println("nearest station:" + st.getIndex());
		assertEquals(st.getIndex(), 's');
	}

	@Test
	public void testCheckNearestStationInt() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testCheckNearestStationInt()");

		double positionX = 1, positionY = 0;
		char index = 'e';

		Estate e = (Estate) Map.addNode("estate", index, positionX, positionY);
		Station s = (Station) Map.addNode("station", 's', 3, 0);

		String name = "apple";
		int age = 18;

		Contacts c = Contacts.add(name, age);
		Apartments a = c.chooseApartment();
		c.bindProperty(a);

		Station st = c.checkNearestStation(0);

		System.out.println("nearest station:" + st.getIndex());
		assertEquals(st.getIndex(), 's');
	}

	@Test
	public void testCheckNearestStationDistance() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testCheckNearestStationDistance()");

		double positionX = 1, positionY = 0;
		char index = 'e';

		Estate e = (Estate) Map.addNode("estate", index, positionX, positionY);
		Station s = (Station) Map.addNode("station", 's', 3, 0);

		String name = "apple";
		int age = 18;

		Contacts c = Contacts.add(name, age);
		Apartments a = c.chooseApartment();
		c.bindProperty(a);

		assertEquals(c.checkNearestStationDistance(), 2.0);
	}

	@Test
	public void testCheckNearestStationDistanceInt() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testCheckNearestStationDistanceInt()");

		double positionX = 1, positionY = 0;
		char index = 'e';

		Estate e = (Estate) Map.addNode("estate", index, positionX, positionY);
		Station s = (Station) Map.addNode("station", 's', 3, 0);

		String name = "apple";
		int age = 18;

		Contacts c = Contacts.add(name, age);
		Apartments a = c.chooseApartment();
		c.bindProperty(a);

		assertEquals(c.checkNearestStationDistance(0), 2.0);
	}

}
