package cs3343_core;

public class CmdStart extends Command {

	public CmdStart() {
		ResourceManager.getInstance().start();
	}

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}

}
