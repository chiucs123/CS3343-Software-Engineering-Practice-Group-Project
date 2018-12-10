package cs3343_testcase.core;

import java.util.ArrayList;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.node.Apartments;
import cs3343_core.node.Connection;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.node.Station;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

@SuppressWarnings("unused")
public class MapTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ResourceManager.start();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		ResourceManager.reset();
	}

	@Test
	public void testMapAddEstate() {
		Map.addNode("estate", 'e');
		assertEquals(Estate.getNodeByCode('e').getType(), "estate");
	}

	@Test
	public void testMapAddStation() {
		Map.addNode("station", 's');
		assertEquals(Station.getNodeByCode('s').getType(), "station");
	}

	@Test
	public void testMapAddNode() {
		Map.addNode("node", 'n');
		assertEquals(Node.getNodeByCode('n').getType(), "node");
	}

	@Test
	public void testMapAddEstateWithCoordinatesAndTestXCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 'e';

		Map.addNode("estate", index, positionX, positionY);
		Node n = Estate.getNodeByCode(index);

		System.out.println("assertEuqals:" + n.getPositionX() + ", " + positionX);

		assertEquals(n.getPositionX(), positionX);
	}

	@Test
	public void testMapAddEstateWithCoordinatesAndTestYCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 'e';

		Map.addNode("estate", index, positionX, positionY);
		Node n = Estate.getNodeByCode(index);

		System.out.println("assertEuqals:" + n.getPositionY() + ", " + positionY);

		assertEquals(n.getPositionY(), positionY);
	}

	@Test
	public void testMapAddStationWithCoordinatesAndTestXCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 's';

		Map.addNode("station", index, positionX, positionY);
		Node n = Station.getNodeByCode(index);

		System.out.println("assertEuqals:" + n.getPositionX() + ", " + positionX);

		assertEquals(n.getPositionX(), positionX);
	}

	@Test
	public void testMapAddStationWithCoordinatesAndTestYCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 's';

		Map.addNode("station", index, positionX, positionY);
		Node n = Station.getNodeByCode(index);

		System.out.println("assertEuqals:" + n.getPositionY() + ", " + positionY);

		assertEquals(n.getPositionY(), positionY);
	}

	@Test
	public void testMapAddNodeWithCoordinatesAndTestXCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 'n';

		Map.addNode("node", index, positionX, positionY);
		Node n = Node.getNodeByCode(index);

		System.out.println("assertEuqals:" + n.getPositionX() + ", " + positionX);

		assertEquals(n.getPositionX(), positionX);
	}

	@Test
	public void testMapAddNodeWithCoordinatesAndTestYCoordinate() {
		double positionX = 1, positionY = 0;
		char index = 'n';

		Map.addNode("node", index, positionX, positionY);
		Node n = Node.getNodeByCode(index);

		System.out.println("assertEuqals:" + n.getPositionY() + ", " + positionY);

		assertEquals(n.getPositionY(), positionY);
	}

//	@Test
//	public void testMapDetermineNearestStation() {
//		Station s = new Station('s', 1 , 0);
//		
//	}

	@Test
	public void testMapGetConnections() {
		Node a = Map.addNode("node", 'a');
		Node b = Map.addNode("node", 'b');
		Connection conn = new Connection(a, b);
		ArrayList<Connection> connections = Map.getConnections();

		assertEquals(conn.equals(connections.get(0)), true);
	}

	@Test
	public void testMapGetConnectedNodes() {
		Node a = Map.addNode("node", 'a', 1, 0);
		Node b = Map.addNode("node", 'b', 2, 0);
		Node c = Map.addNode("node", 'c', 3, 0);

		// MST: a - b - c

		ArrayList<Node> nodes = Map.getConnectedNodes(b);
		System.out.println(nodes);

		assertEquals(nodes.contains(c), true);
	}

	@Test
	public void testRemoveNode() {
		Node a = Map.addNode("node", 'a');

		boolean isSuccess = Map.removeNode(a);

		assertEquals(isSuccess, true);
	}

	@Test
	public void testRemoveNodeFail() {
		boolean isSuccess = Map.removeNode(null);

		assertEquals(isSuccess, false);
	}

	@Test
	public void testMapGetRoute() {
		Node a = Map.addNode("node", 'a', 1, 0);
		Node b = Map.addNode("node", 'b', 2, 0);
		Connection conn = new Connection(a, b);

		ArrayList<Connection> connections = Map.getRoute(a.getIndex(), b.getIndex());

		assertEquals(conn.equals(connections.get(0)), true);
	}

	@Test
	public void testMapGetRouteStringFail() {
		String route = Map.getRouteString('a', 'b');

		assertEquals(route, null);
	}

	@Test
	public void testMapGetRouteString() {
		Node a = Map.addNode("node", 'a', 1, 0);
		Node b = Map.addNode("node", 'b', 2, 0);

		String route = Map.getRouteString(a.getIndex(), b.getIndex());

		assertEquals(route, "a->b: a -> b");
	}

	@Test
	public void testMapGetRouteNodesCostFail() {
		double cost = Map.getRouteNodesCost('a', 'b');

		assertEquals(cost, Double.POSITIVE_INFINITY);
	}

	@Test
	public void testMapGetRouteNodesCost() {
		Node a = Map.addNode("node", 'a', 1, 0);
		Node b = Map.addNode("node", 'b', 2, 0);

		double cost = Map.getRouteNodesCost(a.getIndex(), b.getIndex());

		assertEquals(cost, 1.0);
	}

	@Test
	public void testMapGetConnectionsByNode() {
		Node a = Map.addNode("node", 'a', 1, 0);
		Node b = Map.addNode("node", 'b', 2, 0);

		ArrayList<Connection> connections = Map.getConnectionsByNode(a.getIndex());

		assertEquals(connections.size(), 1);
	}

	@Test
	public void testMapGetConnectionsByNodeFail() {
		Node a = Map.addNode("node", 'a', 1, 0);

		Connection conn = Map.getConnectionsByNode(a, null);

		assertEquals(conn, null);
	}

	@Test
	public void testMapPrintDistances() {
		Map.initialiseMap(5, 5, 5);
		String result = Map.printDistances();
		int numOfLines = result.split("\r\n|\r|\n").length;
//		System.out.println("number of lines: "+numOfLines);
		assertEquals(numOfLines, 18);
	}

	@Test
	public void testMapPrintMST() {
		Node a = Map.addNode("node", 'a', 1, 0);
		Node b = Map.addNode("node", 'b', 2, 0);
		Node c = Map.addNode("node", 'c', 3, 0);

		String result = Map.printMST();
		int numOfLines = result.split("\r\n|\r|\n").length;
		System.out.println("number of lines: " + numOfLines);
		assertEquals(numOfLines, 2);
	}
	
	@Test
	public void testDetermineNearestStation() {
		double positionX = 1, positionY = 0;
		char index = 'e';

		Estate e = (Estate) Map.addNode("estate", index, positionX, positionY);
		Station s = (Station) Map.addNode("station", 's', 3, 0);

		String name = "apple";
		int age = 18;

		Contacts c = Contacts.add(name, age);

		Apartments a = c.chooseApartment();
		System.out.println("apartment: "+ a.toCode());
		
		Station st = Map.determineNearestStation(a);
		
		System.out.println("nearest station:"+ st.getIndex());
		assertEquals(st.getIndex(), 's');
	}
}
