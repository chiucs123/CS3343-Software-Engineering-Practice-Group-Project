package cs3343_testcase;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.node.Station;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class TestAddNode extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ResourceManager.start();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		Node.instances.clear();
		Contacts.reset();
	}

	@Test
	public void testAddEstate() {
		Map.addNode("estate", 'e');
		assertEquals(Estate.getNodeByCode('e').getType(), "estate");
	}

	@Test
	public void testAddStation() {
		Map.addNode("station", 's');
		assertEquals(Station.getNodeByCode('s').getType(), "station");
	}

	@Test
	public void testAddNode() {
		Map.addNode("node", 'n');
		assertEquals(Node.getNodeByCode('n').getType(), "node");
	}

	@Test
	public void testAddEstateWithCoordinatesAndTestXCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 'e';

		Map.addNode("estate", index, positionX, positionY);
		Node n = Estate.getNodeByCode(index);

		assertEquals(n.getPositionX(), positionX);
	}

	@Test
	public void testAddEstateWithCoordinatesAndTestYCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 'e';

		Map.addNode("estate", index, positionX, positionY);
		Node n = Estate.getNodeByCode(index);

		assertEquals(n.getPositionY(), positionY);
	}

	@Test
	public void testAddStationWithCoordinatesAndTestXCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 's';

		Map.addNode("station", index, positionX, positionY);
		Node n = Station.getNodeByCode(index);

		assertEquals(n.getPositionX(), positionX);
	}

	@Test
	public void testAddStationWithCoordinatesAndTestYCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 's';

		Map.addNode("station", index, positionX, positionY);
		Node n = Station.getNodeByCode(index);

		assertEquals(n.getPositionY(), positionY);
	}

	@Test
	public void testAddNodeWithCoordinatesAndTestXCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 'n';

		Map.addNode("node", index, positionX, positionY);
		Node n = Node.getNodeByCode(index);

		assertEquals(n.getPositionX(), positionX);
	}

	@Test
	public void testAddNodeWithCoordinatesAndTestYCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 'n';

		Map.addNode("node", index, positionX, positionY);
		Node n = Node.getNodeByCode(index);

		assertEquals(n.getPositionY(), positionY);
	}

}
