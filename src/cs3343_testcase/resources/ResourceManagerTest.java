package cs3343_testcase.resources;

import org.junit.Test;

import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class ResourceManagerTest extends TestCase {

	@Test
	public void testStart() {
		ResourceManager.start();
		assertEquals(ResourceManager.isStarted(), true); // ResourceManager is already started
	}

}
