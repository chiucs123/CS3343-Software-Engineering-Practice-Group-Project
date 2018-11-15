package cs3343_core;

public class CmdRemoveNode extends Command {

	private Node n = null;

	public CmdRemoveNode(char code) {
		n = Map.getNodeByCode(code);
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
