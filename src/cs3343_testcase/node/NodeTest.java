package cs3343_testcase.node;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

@SuppressWarnings("unused")
public class NodeTest extends TestCase {

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
	public void testNode() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testNode()");
		Node n = new Node();
		assertEquals(Node.instances.size(), 1);
	}

	@Test
	public void testNodeChar() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testNodeChar()");
		Node n = new Node('n');
		assertEquals(Node.instances.get(0).getIndex(), 'n');
	}

	@Test
	public void testNodeCharDoubleDouble() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testNodeCharDoubleDouble()");
		Node n = new Node('n', 1, 0);
		assertEquals(Node.instances.get(0).getIndex() == 'n' && Node.instances.get(0).getPositionX() == 1
				&& Node.instances.get(0).getPositionY() == 0, true);
	}

	@Test
	public void testGetPositionX() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testGetPositionX()");
		Node n = new Node('n', 1, 0);
		assertEquals(n.getPositionX(), 1.0);
	}

	@Test
	public void testGetPositionY() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testGetPositionY()");
		Node n = new Node('n', 1, 0);
		assertEquals(n.getPositionY(), 0.0);
	}

	@Test
	public void testDistanceTo() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testDistanceTo()");
		Node n = new Node('n', 1, 0);
		Node p = new Node('p', 2, 0);
		assertEquals(n.distanceTo(p), 1.0);
	}

	@Test
	public void testGetType() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testGetType()");
		Node n = new Node('n', 1, 0);
		assertEquals(n.getType(), "node");
	}

	@Test
	public void testGetIndex() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testGetIndex()");
		Node n = new Node('n', 1, 0);
		assertEquals(n.getIndex(), 'n');
	}

	@Test
	public void testRemove() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testRemove()");
		Node n = new Node('n', 1, 0);
		n.remove();
		assertEquals(Node.instances.size(), 0);
	}

	@Test
	public void testGetNodeByCode() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testGetNodeByCode()");
		Node n = new Node('n', 1, 0);
		assertEquals(Node.getNodeByCode('n'), n);
	}

	@Test
	public void testEqualsNode() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testEqualsNode()");
		Node n = new Node('n', 1, 0);
		assertEquals(Node.getNodeByCode('n').equals(n), true);
	}

}
