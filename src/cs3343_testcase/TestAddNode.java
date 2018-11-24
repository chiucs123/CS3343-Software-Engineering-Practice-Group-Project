package cs3343_testcase;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cs3343_core.Map;
import cs3343_core.console.Command;
import cs3343_core.console.Console;
import cs3343_core.node.Connection;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.node.Station;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class TestAddNode extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testAddEstate() {
		Map.addNode("estate", 'e', 0, 0);
		assertEquals(Estate.getNodeByCode('e').getIndex(), 'e');
	}

	@Test
	public void testAddStation() {
		Map.addNode("station", 's', 1, 0);
		assertEquals(Station.getNodeByCode('s').getIndex(), 's');
	}

	@Test
	public void testAddNode() {
		Map.addNode("node", 'n', 2, 0);
		assertEquals(Node.getNodeByCode('n').getIndex(), 'n');
	}

}
