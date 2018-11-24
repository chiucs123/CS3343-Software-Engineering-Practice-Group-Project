package cs3343_testcase;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class TestGetRouteCost extends TestCase{
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ResourceManager.start();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		for(Node n : Node.instances)
			Map.removeNode(n);
		Contacts.reset();
	}
}
