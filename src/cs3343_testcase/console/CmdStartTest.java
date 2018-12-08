package cs3343_testcase.console;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.console.CmdStart;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class CmdStartTest extends TestCase {
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
	public void testCmdStart() {
		CmdStart cmd = new CmdStart();
		assertEquals(ResourceManager.isStarted(), true); // ResourceManager is already started
	}

}
