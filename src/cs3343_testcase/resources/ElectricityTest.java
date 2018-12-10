package cs3343_testcase.resources;

import org.junit.Test;

import cs3343_core.resources.Electricity;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class ElectricityTest extends TestCase {
	
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
		Electricity e = new Electricity();
		assertEquals(e.getType(), "electricity");
	}

}
