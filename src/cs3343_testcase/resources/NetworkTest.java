package cs3343_testcase.resources;

import org.junit.Test;

import cs3343_core.resources.Network;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class NetworkTest extends TestCase {
	
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
	public void testGetType() {
		Network n = new Network();
		assertEquals(n.getType(), "network");
	}

}
