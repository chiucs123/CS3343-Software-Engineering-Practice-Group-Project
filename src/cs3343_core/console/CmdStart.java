package cs3343_core.console;

import cs3343_core.resources.ResourceManager;

public class CmdStart extends Command {

	public CmdStart() {
		if(ResourceManager.start()) {
			System.out.println("Resource Manager is now running.");
		}else{
			System.out.println("Resource Manager is already running.");
		}
	}

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}

}
