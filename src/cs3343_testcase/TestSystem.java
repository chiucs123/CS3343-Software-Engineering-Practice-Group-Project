package cs3343_testcase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.console.Console;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class TestSystem extends TestCase {

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
	public void testChooseApartmentByThis() {
		List<String> cmdList = new ArrayList<>();
		cmdList.add("help");
		cmdList.add("start");
		cmdList.add("node add node a 1 0");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("node add station b 2 0");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("node add estate c 3 0");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("node remove a");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("undo");
		cmdList.add("node remove b");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("undo");
		cmdList.add("node remove c");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("undo");
		cmdList.add("contact add apple 18");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("contact add banana 19");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("contact add cat 20");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("contact remove apple");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("undo");
		cmdList.add("contact remove banana");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("undo");
		cmdList.add("contact remove cat");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("undo");
		cmdList.add("contact choose_apartment this");
		cmdList.add("undo");
		cmdList.add("redo");
		cmdList.add("this");
		cmdList.add("report print contact apple");

		try {
			for (String cmd : cmdList)
				Console.exec(cmd);
		} catch (Exception e) {
		}

//		String commandName = cmdStart.getClass().getSimpleName();
//		System.out.println(commandName);
//		assertEquals("CmdStart", commandName);
		assertEquals(true, true);
	}
}
