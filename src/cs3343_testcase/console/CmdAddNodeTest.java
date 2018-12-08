package cs3343_testcase.console;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.console.CmdAddNode;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class CmdAddNodeTest extends TestCase {

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
	public void testUndo() {
		CmdAddNode cmd = new CmdAddNode("node", 'e', 1, 0);
		cmd.undo();
		assertEquals(Node.instances.size(), 0);
	}

	@Test
	public void testRedo() {
		CmdAddNode cmd = new CmdAddNode("node", 'e', 1, 0);
		cmd.undo();
		cmd.redo();
		assertEquals(Node.instances.size(), 1);
	}

	@Test
	public void testCmdAddNodeStringChar() {
		CmdAddNode cmd = new CmdAddNode("node", 'e');
		assertEquals(Node.instances.size(), 1);
	}

	@Test
	public void testCmdAddNodeStringCharDoubleDouble() {
		CmdAddNode cmd = new CmdAddNode("node", 'e', 1, 0);
		assertEquals(Node.instances.size(), 1);
	}

	@Test
	public void testGetHandlingNode() {
		CmdAddNode cmd = new CmdAddNode("node", 'e');
		Node n = cmd.getHandlingNode();
		assertEquals(n.getIndex(), 'e');
	}

}
