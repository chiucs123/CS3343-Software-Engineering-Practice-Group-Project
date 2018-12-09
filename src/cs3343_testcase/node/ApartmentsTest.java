package cs3343_testcase.node;

import org.junit.Test;

import cs3343_core.Contacts;
import cs3343_core.node.Apartments;
import cs3343_core.node.Estate;
import cs3343_core.node.Node;
import cs3343_core.resources.ResourceManager;
import junit.framework.TestCase;

public class ApartmentsTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ResourceManager.start();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		Node.reset();
		Contacts.reset();
	}

	@Test
	public void testApartments() {
		Estate s = new Estate('s', 1, 0);
		int originalSize = Apartments.instances.size();
		Apartments a = new Apartments(s, 1, 'A');
		assertEquals(Apartments.instances.size(), originalSize + 1);
	}

	@Test
	public void testGetAddress() {
		Estate s = new Estate('s', 1, 0);
		Apartments a = new Apartments(s, 1, 'A');

		String address = a.getAddress();
		assertEquals(address, "Rm. A, 1/F, " + s.getName());
	}

	@Test
	public void testGetMultilineAddress() {
		Estate s = new Estate('s', 1, 0);
		Apartments a = new Apartments(s, 1, 'A');

		String address = a.getMultilineAddress();
		assertEquals(address, "Rm. A, 1/F\n" + s.getName());
	}

	@Test
	public void testGetFloor() {
		Estate s = new Estate('s', 1, 0);
		Apartments a = new Apartments(s, 1, 'A');

		assertEquals(a.getFloor(), 1);
	}

	@Test
	public void testGetEstate() {
		Estate s = new Estate('s', 1, 0);
		Apartments a = new Apartments(s, 1, 'A');

		assertEquals(a.getEstate(), s);
	}

	@Test
	public void testToString() {
		Estate s = new Estate('s', 1, 0);
		Apartments a = new Apartments(s, 1, 'A');

		assertEquals(a.toString(), "Estate Apartment  1/F Rm.A @ " + s.getName() + ".");

	}

	@Test
	public void testToCode() {
		Estate s = new Estate('s', 1, 0);
		Apartments a = new Apartments(s, 1, 'A');

		assertEquals(a.toCode(), " 1A");
	}

	@Test
	public void testInhabit() {
		Estate s = new Estate('s', 1, 0);
		Contacts c = new Contacts("banana", 19);
		Apartments a = new Apartments(s, 1, 'A');

		assertEquals(a.inhabit(c), true); // Estate has apartment available for banana to move in.
	}

}
