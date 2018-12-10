package cs3343_testcase.resources;

import org.junit.Test;

import cs3343_core.Map;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class ResourceManagerTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ResourceManager.start();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		ResourceManager.reset();
	}

	@Test
	public void testStart() {
		ResourceManager.start();
		assertEquals(ResourceManager.isStarted(), true); // ResourceManager is already started
	}

	@Test
	public void testReset() {
		Map.addNode("node", 'a');
		ResourceManager.reset();
		assertEquals(Node.instances.size(), 0);
	}

}
