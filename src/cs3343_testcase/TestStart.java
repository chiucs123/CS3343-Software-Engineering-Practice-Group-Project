package cs3343_testcase;

import org.junit.Test;

import cs3343_core.console.Command;
import cs3343_core.console.Console;
import junit.framework.TestCase;

public class TestStart extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testStart_1() {
		Command cmdStart = Console.exec("start");
		String commandName = cmdStart.getClass().getSimpleName();
//		System.out.println(commandName);
		assertEquals("CmdStart", commandName);
	}
	
}
