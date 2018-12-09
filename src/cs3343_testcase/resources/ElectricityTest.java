package cs3343_testcase.resources;

import org.junit.Test;

import cs3343_core.resources.Electricity;
import junit.framework.TestCase;

public class ElectricityTest extends TestCase {

	@Test
	public void testGetType() {
		Electricity e = new Electricity();
		assertEquals(e.getType(), "electricity");
	}

}
