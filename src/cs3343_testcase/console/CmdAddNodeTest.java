package cs3343_testcase.console;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.console.CmdAddNode;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

@SuppressWarnings("unused")
public class CmdAddNodeTest extends TestCase {

	private int testIndex = 1;

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
	public void testUndo() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testUndo()");
		CmdAddNode cmd = new CmdAddNode("node", 'e', 1, 0);
		cmd.undo();
		assertEquals(Node.instances.size(), 0);
	}

	@Test
	public void testRedo() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testRedo()");
		CmdAddNode cmd = new CmdAddNode("node", 'e', 1, 0);
		cmd.undo();
		cmd.redo();
		assertEquals(Node.instances.size(), 1);
	}

	@Test
	public void testCmdAddNodeStringChar() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testCmdAddNodeStringChar()");
		CmdAddNode cmd = new CmdAddNode("node", 'e');
		assertEquals(Node.instances.get(0).getIndex(), 'e');
	}

	@Test
	public void testCmdAddNodeStringCharDoubleDouble() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testCmdAddNodeStringCharDoubleDouble()");
		CmdAddNode cmd = new CmdAddNode("node", 'e', 1, 0);
		assertEquals(Node.instances.get(0).getIndex() == 'e' && Node.instances.get(0).getPositionX() == 1
				&& Node.instances.get(0).getPositionY() == 0, true);
	}

	@Test
	public void testGetHandlingNode() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testGetHandlingNode()");
		CmdAddNode cmd = new CmdAddNode("node", 'e');
		Node n = cmd.getHandlingNode();
		assertEquals(n.getIndex(), 'e');
	}

}
