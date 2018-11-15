package cs3343_core;

public class CmdGetCostRoute extends Command {

	public CmdGetCostRoute(char from, char to) {
		Map.getRouteNodesCost(from, to);
	}

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}

}
