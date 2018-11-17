package cs3343_core.console;

import cs3343_core.Map;
import cs3343_core.node.Node;

public class CmdAddNode extends Command {

	private Node n = null;
	private boolean hasLocation = false;
	private String type = "";
	private char index = ' ';
	private double x = 0.0;
	private double y = 0.0;

	public CmdAddNode(String type, char index) {
		this.type = type;
		this.index = index;
		n = Map.addNode(type, index);
		hasLocation = false;
	}

	public CmdAddNode(String type, char index, double x, double y) {
		this.type = type;
		this.index = index;
		this.x = x;
		this.y = y;
		n = Map.addNode(type, index, x, y);
		hasLocation = true;
	}

	public Node getHandlingNode() {
		return n;
	}

	@Override
	public void undo() {
		if (n != null) {
			Map.removeNode(n);
		}
	}

	@Override
	public void redo() {
		if (hasLocation) {
			n = Map.addNode(type, index, x, y);
		} else {
			n = Map.addNode(type, index);
		}
	}

}
