package cs3343_core.console;

import cs3343_core.Map;
import cs3343_core.node.Node;

public class CmdRemoveNode extends Command {

	private Node n = null;

	public CmdRemoveNode(char code) {
		n = Node.getNodeByCode(code);
		if (n != null) {
			Map.removeNode(n);
		}
	}

	@Override
	public void undo() {
		Map.addNode(n.getType(), n.getIndex());
	}

	@Override
	public void redo() {
		if (n != null) {
			Map.removeNode(n);
		}

	}

}
