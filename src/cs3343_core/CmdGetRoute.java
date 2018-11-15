package cs3343_core;

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
