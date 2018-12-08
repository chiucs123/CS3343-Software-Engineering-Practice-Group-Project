package cs3343_testcase.node;

import java.util.ArrayList;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.node.Connection;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.node.Station;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class TestNode extends TestCase {

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
	public void testMapAddEstate() {
//		Map.addNode("estate", 'e');
//		assertEquals(Estate.getNodeByCode('e').getType(), "estate");
	}
}
