package cs3343_testcase.resources;

import org.junit.Test;

import cs3343_core.resources.ResourceManager;
import cs3343_core.resources.Water;
import junit.framework.TestCase;

public class WaterTest extends TestCase {
	
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
		Water w = new Water();
		assertEquals(w.getType(), "water");
	}

}
