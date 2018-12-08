package cs3343_testcase;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.console.Console;
import cs3343_core.node.Apartments;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class TestChooseApartment extends TestCase {

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
	public void testChooseApartmentByThis() {
		double positionX = 1, positionY = 0;
		char index = 'e';

		Estate e = (Estate) Map.addNode("estate", index, positionX, positionY);

		String name = "apple";
		int age = 18;

		Console.exec("contact add " + name + " " + age);

		Apartments a = ((Contacts) Console.getHandle()).chooseApartment();

		assertEquals(a.getEstate().getName(), e.getName());
	}

	@Test
	public void testChooseApartmentByName() {
		double positionX = 1, positionY = 0;
		char index = 'e';

		Estate e = (Estate) Map.addNode("estate", index, positionX, positionY);

		String name = "apple";
		int age = 18;

		Contacts c = Contacts.add(name, age);

		Apartments a = c.chooseApartment();

		assertEquals(a.getEstate().getName(), e.getName());
	}
}
