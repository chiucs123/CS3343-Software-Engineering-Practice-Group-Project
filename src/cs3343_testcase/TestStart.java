package cs3343_testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import cs3343_core.console.CmdStart;
import cs3343_core.console.Command;
import cs3343_core.console.Console;

public class TestStart {

	@Test
	public void testStart_1() {
		Command cmdStart = Console.exec("start");
		String commandName = cmdStart.getClass().getSimpleName();
//		System.out.println(commandName);
		assertEquals("CmdStart", commandName);
	}
	
}
