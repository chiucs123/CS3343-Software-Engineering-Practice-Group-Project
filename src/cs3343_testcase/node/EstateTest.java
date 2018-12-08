package cs3343_testcase.node;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.node.Station;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class EstateTest extends TestCase {
	
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
		Estate s = new Estate('s', 1, 0);
		assertEquals(s.getType(), "estate");
	}

	@Test
	public void testEstate() {
		Estate e = new Estate();
		assertEquals(Estate.instances.size(), 1);
	}

	@Test
	public void testEstateChar() {
		Estate e = new Estate('s');
		assertEquals(Estate.instances.size(), 1);
	}

	@Test
	public void testEstateCharDoubleDouble() {
		Estate e = new Estate('s', 1, 0);
		assertEquals(Estate.instances.size(), 1);
	}

	@Test
	public void testMoveIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetApartmentsByFloor() {
		fail("Not yet implemented");
	}

}
