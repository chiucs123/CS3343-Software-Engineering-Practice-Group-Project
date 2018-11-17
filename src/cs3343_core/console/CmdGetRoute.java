package cs3343_core.console;

import cs3343_core.resources.ResourceManager;

public class CmdGetRoute extends Command {

	public CmdGetRoute(char from, char to) {
		ResourceManager.getInstance().getRoute(from, to);
	}

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}

}
