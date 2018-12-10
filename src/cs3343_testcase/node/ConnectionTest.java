package cs3343_testcase.node;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.node.Connection;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class ConnectionTest extends TestCase {

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
	public void testConnection() {
		Node n = new Node('n');
		Node o = new Node('o');

		Connection conn = new Connection(n, o);
		assertEquals(conn.instances.size(), 1);
	}

	@Test
	public void testHasNode() {
		Node n = new Node('n');
		Node o = new Node('o');

		Connection conn = new Connection(n, o);
		assertEquals(conn.hasNode(n), true);
	}

	@Test
	public void testGetNodeA() {
		Node n = new Node('n');
		Node o = new Node('o');

		Connection conn = new Connection(n, o);
		assertEquals(conn.getNodeA(), n);
	}

	@Test
	public void testGetNodeB() {
		Node n = new Node('n');
		Node o = new Node('o');

		Connection conn = new Connection(n, o);
		assertEquals(conn.getNodeB(), o);
	}

	@Test
	public void testGetDistance() {
		Node n = new Node('n', 1, 0);
		Node o = new Node('o', 2, 0);

		Connection conn = new Connection(n, o);
		assertEquals(conn.getDistance(), 1.0);
	}

	@Test
	public void testToString() {
		Node n = new Node('n', 1, 0);
		Node o = new Node('o', 2, 0);

		Connection conn = new Connection(n, o);

		String toString = conn.toString();

		assertEquals(toString, "n <--  1.00--> o");
	}

	@Test
	public void testEqualsConnection() {
		Node n = new Node('n');
		Node o = new Node('o');

		Connection conn = new Connection(n, o);
		assertEquals(conn.equals(new Connection(o, n)), true);
	}

}
