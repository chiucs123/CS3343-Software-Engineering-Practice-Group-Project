package cs3343_testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import cs3343_core.*;
import cs3343_core.node.Connection;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;

public class Testcases {

	@Test
	public void testcase_1() {
		ResourceManager.start();
		Node result = Node.getNodeByCode('z');
		assertEquals(null, result);
	}

	@Test
	public void testcase_2() {
		ResourceManager.start();
		Node result = Node.getNodeByCode('a');
		assertEquals('a', result.getIndex());
	}

	@Test
	public void testcase_3() {
		ResourceManager.start();
		ArrayList<Connection> result = Map.getConnectionsByNode('a');
		assertEquals(false, result.isEmpty());
	}
}