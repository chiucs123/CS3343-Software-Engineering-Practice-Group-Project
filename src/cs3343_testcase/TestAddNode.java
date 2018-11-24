package cs3343_testcase;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cs3343_core.Map;
import cs3343_core.console.Command;
import cs3343_core.console.Console;
import cs3343_core.node.Connection;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.node.Station;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class TestAddNode extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testAddEstate() {
		Map.addNode("estate", 'e');
		assertEquals(Estate.getNodeByCode('e').getType(), "estate");
		
		Map.removeNode(Node.getNodeByCode('e'));
	}

	@Test
	public void testAddStation() {
		Map.addNode("station", 's');
		assertEquals(Station.getNodeByCode('s').getType(), "station");
		
		Map.removeNode(Node.getNodeByCode('s'));
	}

	@Test
	public void testAddNode() {
		Map.addNode("node", 'n');
		assertEquals(Node.getNodeByCode('n').getType(), "node");
		
		Map.removeNode(Node.getNodeByCode('n'));

	}

	@Test
	public void testAddEstateWithCoordinates() {
		double positionX = 1, positionY = 0;
		char index = 'f';

		Map.addNode("estate", index, positionX, positionY);
		Node n = Estate.getNodeByCode(index);
		boolean sameCoordinate = n.getPositionX() == positionX && n.getPositionY() == positionY;

		assertEquals(sameCoordinate, true);
		
		Map.removeNode(Node.getNodeByCode(index));
	}

	@Test
	public void testAddStationWithCoordinates() {
		double positionX = 2, positionY = 0;
		char index = 't';

		Map.addNode("station", index, positionX, positionY);
		Node n = Station.getNodeByCode(index);
		boolean sameCoordinate = n.getPositionX() == positionX && n.getPositionY() == positionY;

		assertEquals(sameCoordinate, true);
		
		Map.removeNode(Node.getNodeByCode(index));
	}

	@Test
	public void testAddNodeWithCoordinates() {
		double positionX = 3, positionY = 0;
		char index = 'p';

		Map.addNode("node", index, positionX, positionY);
		Node n = Node.getNodeByCode(index);
		boolean sameCoordinate = n.getPositionX() == positionX && n.getPositionY() == positionY;

		assertEquals(sameCoordinate, true);
		
		Map.removeNode(Node.getNodeByCode(index));
	}

}
