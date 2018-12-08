package cs3343_testcase.resources;

import org.junit.Test;

import cs3343_core.resources.Gas;
import junit.framework.TestCase;

public class GasTest extends TestCase {

	@Test
	public void testGetType() {
		Gas g = new Gas();
		assertEquals(g.getType(), "gas");
	}

}
