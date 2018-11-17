package cs3343_core.console;

import cs3343_core.Map;

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
