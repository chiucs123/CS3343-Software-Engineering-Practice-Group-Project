package cs3343_testcase.resources;

import org.junit.Test;

import cs3343_core.resources.Water;
import junit.framework.TestCase;

public class WaterTest extends TestCase {

	@Test
	public void testGetType() {
		Water w = new Water();
		assertEquals(w.getType(), "water");
	}

}
