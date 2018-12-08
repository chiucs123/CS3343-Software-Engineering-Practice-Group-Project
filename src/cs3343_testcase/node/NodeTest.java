package cs3343_testcase.node;

import static org.junit.Assert.*;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class NodeTest extends TestCase {

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
	public void testNode() {
		Node n = new Node();
		assertEquals(Node.instances.size(), 1);
	}

	@Test
	public void testNodeChar() {
		Node n = new Node('n');
		assertEquals(Node.instances.size(), 1);
	}

	@Test
	public void testNodeCharDoubleDouble() {
		Node n = new Node('n', 1, 0);
		assertEquals(Node.instances.size(), 1);
	}

	@Test
	public void testGetPositionX() {
		Node n = new Node('n', 1, 0);
		assertEquals(n.getPositionX(), 1.0);
	}

	@Test
	public void testGetPositionY() {
		Node n = new Node('n', 1, 0);
		assertEquals(n.getPositionY(), 0.0);
	}

	@Test
	public void testDistanceTo() {
		Node n = new Node('n', 1, 0);
		Node p = new Node('p', 2, 0);
		assertEquals(n.distanceTo(p), 1.0);
	}

	@Test
	public void testGetType() {
		Node n = new Node('n', 1, 0);
		assertEquals(n.getType(), "node");
	}

	@Test
	public void testGetIndex() {
		Node n = new Node('n', 1, 0);
		assertEquals(n.getIndex(), 'n');
	}

	@Test
	public void testRemove() {
		Node n = new Node('n', 1, 0);
		n.remove();
		assertEquals(Node.instances.size(), 0);
	}

	@Test
	public void testGetNodeByCode() {
		Node n = new Node('n', 1, 0);
		assertEquals(Node.getNodeByCode('n'), n);
	}

	@Test
	public void testEqualsNode() {
		Node n = new Node('n', 1, 0);
		assertEquals(Node.getNodeByCode('n').equals(n), true);
	}

}
