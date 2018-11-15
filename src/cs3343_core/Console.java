package cs3343_core;

import java.util.*;

public class Console {
	private static final Console instance = new Console();
	private static ArrayList<Command> historyDone = new ArrayList<>();
	private static ArrayList<Command> historyUndo = new ArrayList<>();
	private static int count = 0;

	private static Object lastHandle = null;

	private Console() {
	}

	private static void unsetHandles() {
		lastHandle = null;
	}

	private static void setHandles(Object o) {
		lastHandle = o;
	}

	private static Object getHandle() {
		return lastHandle;
	}

	public static Command exec(String cmd) {
		String[] params = cmd.split(" ");
		Command c = null;
		boolean qualifyUndo = true;

		switch (params[0]) {
		case "start":
			c = new CmdStart();
			unsetHandles();
			resetRedo();
			break;
		case "node":
			switch (params[1]) {
			case "add":
				if (params.length == 5) {
					c = new CmdAddNode(params[2], (char) params[3].charAt(0), Double.parseDouble(params[4]),
							Double.parseDouble(params[5]));
				} else if (params.length == 3) {
					c = new CmdAddNode(params[2], (char) params[3].charAt(0));
				}
				if (c != null) {
					unsetHandles();
					setHandles(((CmdAddNode) c).getHandlingNode());
				}
				break;
			case "remove":
				if (params.length == 3) {
					c = new CmdRemoveNode((char) params[2].charAt(0));
				}
				unsetHandles();
				break;
			}
			resetRedo();
			break;
		case "contact":
			switch (params[1]) {
			case "add":
				if (params.length == 4) {
					c = new CmdAddContact(params[2], Integer.parseInt(params[3]));
				}
				if (c != null) {
					unsetHandles();
					setHandles(((CmdAddContact) c).getHandlingContact());
				}
				break;
			case "remove":
				if (params.length == 3) {
					c = new CmdRemoveContact(params[2]);
				}
				unsetHandles();
				break;
			}
			resetRedo();
			break;
		case "get":
			switch (params[1]) {
			case "route":
				switch (params[2]) {
				case "path":
					if (params.length == 5) {
						c = new CmdGetRoute((char) params[3].charAt(0), (char) params[4].charAt(0));
					}
					qualifyUndo = false;
					break;
				case "cost":
					if (params.length == 5) {
						c = new CmdGetCostRoute((char) params[3].charAt(0), (char) params[4].charAt(0));
					}
					qualifyUndo = false;
					break;
				}
				break;
			}
			break;
		case "this":
			if (params.length == 1) {
				if (getHandle() == null) {
					System.out.println("Current Handle: none");
				} else {
					System.out.println("Current Handle: " + getHandle().getClass().getName() + " - " + getHandle());
				}
				qualifyUndo = false;
			} else {

			}
		case "undo": {
			Console.undo();
			break;
		}
		case "redo": {
			Console.redo();
			break;
		}
		default:
			break;
		}

		if (qualifyUndo)

		{
			historyDone.add(c);
			count++;
		}
		return c;
	}

	public static Console getInstance() {
		return instance;
	}

	public static int getCmdCount() {
		return count;
	}

	public static Command undo() {
		Command c = historyDone.get(historyDone.size() - 1);
		c.undo();
		historyUndo.add(c);
		historyDone.remove(historyDone.size() - 1);
		return c;
	}

	public static Command redo() {
		Command c = historyUndo.get(historyUndo.size() - 1);
		c.redo();
		historyDone.add(c);
		historyUndo.remove(historyUndo.size() - 1);
		return c;
	}

	private static void resetRedo() {
		historyUndo.clear();
	}
}
