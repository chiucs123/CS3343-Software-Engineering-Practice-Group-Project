package cs3343_testcase.console;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.console.CmdRemoveNode;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

@SuppressWarnings("unused")
public class CmdRemoveNodeTest extends TestCase {

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
	public void testUndo() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testUndo()");
		Map.addNode("node", 'n');
		CmdRemoveNode cmd = new CmdRemoveNode('n');
		cmd.undo();
		assertEquals(Node.getNodeByCode('n').getIndex(), 'n');
	}

	@Test
	public void testRedo() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testRedo()");
		Map.addNode("node", 'n');
		CmdRemoveNode cmd = new CmdRemoveNode('n');
		cmd.undo();
		cmd.redo();
		assertEquals(Node.getNodeByCode('n').getIndex(), 'n');
	}

	@Test
	public void testCmdRemoveNode() {
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("Testcase " + (testIndex++) + " : testCmdRemoveNode()");
		Map.addNode("node", 'n');
		CmdRemoveNode cmd = new CmdRemoveNode('n');
		assertEquals(Node.getNodeByCode('n'), null);
	}

}
