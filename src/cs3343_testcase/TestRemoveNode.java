package cs3343_testcase;

import org.junit.Test;

import cs3343_core.Map;
import cs3343_core.node.Node;
import junit.framework.TestCase;

public class TestRemoveNode extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testRemoveNodeSuccess() {
		double positionX = 4, positionY = 0;
		char index = 'n';

		Map.addNode("node", index, positionX, positionY);

		boolean removeSuccess = Map.removeNode(Node.getNodeByCode(index));
		
		assertEquals(removeSuccess, true);
	}
	
	@Test
	public void testRemoveNodeFail() {
		char index = 'n';

		boolean removeSuccess = Map.removeNode(Node.getNodeByCode(index));

		assertEquals(removeSuccess, false);
	}
}
