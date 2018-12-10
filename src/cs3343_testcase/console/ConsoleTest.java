/**
 * 
 */
package cs3343_testcase.console;

import org.junit.Test;

import cs3343_core.console.Command;
import cs3343_core.console.Console;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class ConsoleTest extends TestCase {

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

	/**
	 * Test method for {@link cs3343_core.console.Console#getHandle()}.
	 */
	@Test
	public void testGetHandle() {
		Console.exec("node add node n");
		Object cmd = Console.getHandle(); // equivalent to "this" in command line
		assertEquals(cmd.getClass().getName(), "cs3343_core.node.Node");
	}

	/**
	 * Test method for {@link cs3343_core.console.Console#exec(java.lang.String)}.
	 */
	@Test
	public void testExec() {
		Command cmd = (Command) Console.exec("node add node n");
		assertEquals(cmd.getClass().getName(), "cs3343_core.console.CmdAddNode");
	}

	/**
	 * Test method for {@link cs3343_core.console.Console#getCmdCount()}.
	 */
	@Test
	public void testGetCmdCount() {
		Command cmd = (Command) Console.exec("node add node n");
		assertEquals(Console.getCmdCount(), 1);
	}

	/**
	 * Test method for {@link cs3343_core.console.Console#undo()}.
	 */
	@Test
	public void testUndo() {
		Console.exec("node add node n");
		Console.undo();
		assertEquals(Node.instances.size(), 0);
	}

	/**
	 * Test method for {@link cs3343_core.console.Console#redo()}.
	 */
	@Test
	public void testRedo() {
		Console.exec("node add node n");
		Console.undo();
		Console.redo();
		assertEquals(Node.instances.size(), 1);
	}

}
