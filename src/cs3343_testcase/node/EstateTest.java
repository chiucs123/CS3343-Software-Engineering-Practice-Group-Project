package cs3343_testcase.node;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.node.Station;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class EstateTest extends TestCase {

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
	public void testGetType() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testGetType()");
		Estate s = new Estate('s', 1, 0);
		assertEquals(s.getType(), "estate");
	}

	@Test
	public void testEstate() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testEstate()");
		Estate e = new Estate();
		assertEquals(Estate.instances.size(), 1);
	}

	@Test
	public void testEstateChar() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testEstateChar()");
		Estate e = new Estate('s');
		assertEquals(Estate.instances.get(0).getIndex(), 's');
	}

	@Test
	public void testEstateCharDoubleDouble() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testEstateCharDoubleDouble()");
		Estate e = new Estate('s', 1, 0);
		assertEquals(Estate.instances.get(0).getIndex() == 's' && Estate.instances.get(0).getPositionX() == 1
				&& Estate.instances.get(0).getPositionY() == 0, true);
	}

	@Test
	public void testMoveIn() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testMoveIn()");
		Estate e = new Estate('s', 1, 0);
		Contacts c = new Contacts("banana", 19);

		assertEquals(e.moveIn(c), true); // Estate has apartment available for banana to move in.
	}

	@Test
	public void testGetApartmentsByFloor() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testGetApartmentsByFloor()");
		Estate e = new Estate();
		assertEquals(e.getFloors() > 0, true);
	}

}
