package cs3343_core.console;

import cs3343_core.resources.ResourceManager;

public class CmdStart extends Command {

	public CmdStart() {
		ResourceManager.start();
	}

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}

}
