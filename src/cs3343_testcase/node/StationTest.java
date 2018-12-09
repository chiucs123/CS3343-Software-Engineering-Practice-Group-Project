package cs3343_testcase.node;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.node.Node;
import cs3343_core.node.Station;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

@SuppressWarnings("unused")
public class StationTest extends TestCase {

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
		Station s = new Station('s', 1, 0);
		assertEquals(s.getType(), "station");
	}

	@Test
	public void testStationChar() {
		Station s = new Station('s');
		assertEquals(Station.instances.size(), 1);
	}

	@Test
	public void testStationCharDoubleDouble() {
		Station s = new Station('s', 1, 0);
		assertEquals(Station.instances.size(), 1);
	}

}
