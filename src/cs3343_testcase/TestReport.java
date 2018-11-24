package cs3343_testcase;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.Map;
import cs3343_core.node.Apartments;
import junit.framework.TestCase;

public class TestReport extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testReport_1() {
		Map.addNode("station", 's');
		Map.addNode("estate", 'e');
		Contacts c = Contacts.add("apple", 18);
		Apartments a = c.chooseApartment();
		thi
	}
}
