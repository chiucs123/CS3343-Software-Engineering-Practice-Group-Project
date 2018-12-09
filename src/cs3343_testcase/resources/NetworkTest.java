package cs3343_testcase.resources;

import org.junit.Test;

import cs3343_core.resources.Network;
import junit.framework.TestCase;

public class NetworkTest extends TestCase {

	@Test
	public void testGetType() {
		Network n = new Network();
		assertEquals(n.getType(), "network");
	}

}
