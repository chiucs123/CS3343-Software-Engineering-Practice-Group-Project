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

	@Test
	public void testcase_4() {
		ResourceManager.start();
		ArrayList<Node> list = new ArrayList<>();
		list.add(Map.addNode("node", 'a'));
		list.add(Map.addNode("node", 'b'));
		list.add(Map.addNode("node", 'c'));
		list.add(Map.addNode("station", 's'));

		Connection c1 = new Connection(list.get(0), list.get(1));		
		Connection c2 = Map.getConnectionsByNode(list.get(0), list.get(1));
		
		boolean isEquals = c1.equals(c2);
//		System.out.println("c1=" + c1);
//		System.out.println("c2=" + c2);
		assertEquals(isEquals, true);
	}

}
