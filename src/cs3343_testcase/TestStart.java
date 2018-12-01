package cs3343_testcase;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.console.Command;
import cs3343_core.console.Console;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class TestStart extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ResourceManager.start();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		Node.instances.clear();
		Contacts.reset();
	}

	@Test
	public void testStart_1() {
		Command cmdStart = Console.exec("start");
		String commandName = cmdStart.getClass().getSimpleName();
//		System.out.println(commandName);
		assertEquals("CmdStart", commandName);
	}
	
}
