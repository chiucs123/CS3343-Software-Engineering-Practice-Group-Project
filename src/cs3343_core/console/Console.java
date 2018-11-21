package cs3343_core.console;

import java.util.*;

import cs3343_core.Contacts;
import cs3343_core.Report;

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
				if (params.length == 6) {
					c = new CmdAddNode(params[2], (char) params[3].charAt(0), Double.parseDouble(params[4]),
							Double.parseDouble(params[5]));
				} else if (params.length == 4) {
					c = new CmdAddNode(params[2], (char) params[3].charAt(0));
				} else {
					System.out.println(
							"Node add operation expecting exactly 2 or 4 parameters! Usage: node add <type> <index> [x] [y].");
				}
				if (c != null) {
					unsetHandles();
					setHandles(((CmdAddNode) c).getHandlingNode());
				}
				break;
			case "remove":
				if (params.length == 3) {
					c = new CmdRemoveNode((char) params[2].charAt(0));
				} else {
					System.out.println("Node add operation expecting exactly 1 parameter! Usage: node remove <index>.");
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
				} else {
					System.out.println(
							"Contact add operation expecting exactly 2 parameters! Usage: contact add <name> <age>.");
				}
				if (c != null) {
					unsetHandles();
					setHandles(((CmdAddContact) c).getHandlingContact());
				}
				break;
			case "remove":
				if (params.length == 3) {
					c = new CmdRemoveContact(params[2]);
				} else {
					System.out.println(
							"Contact add operation expecting exactly 1 parameter! Usage: contact remove <name>.");
				}
				unsetHandles();
				break;
			case "choose_apartment":
				if (params[2].equals("this")) {
					((Contacts) lastHandle).chooseApartment();
				} else if (params.length == 3) {
					Contacts.getContactByName(params[3]).chooseApartment();
				} else {
					System.out.println(
							"Contact add operation expecting exactly 1 parameter! Usage: contact choose_apartment <name|this>.");
				}
				break;
			}

			resetRedo();
			break;
		case "report":
			switch (params[1]) {
			case "print":
				switch (params[2]) {
				case "line":
					Report.printLine();
					break;
				case "contact":
					if (params.length > 3 && params[3].equals("this")) {
						c = new CmdReportPrintContacts((Contacts) lastHandle);
						break;
					}
				}
				qualifyUndo = false;
				break;
			}
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
				System.out.println("Operation this only shows last handled object.");
			}
		case "undo": {
			Console.undo();
			break;
		}
		case "redo": {
			Console.redo();
			break;
		}
		case "?":
		case "help": {
			System.out.println("------------------------------HELP------------------------------");
			System.out.println("This console allows manipulation to the resource manager via cmd");
			System.out.println();
			System.out.println("Accepted commands:                                              ");
			System.out.println("- start                                                         ");
			System.out.println("      Starts the Resource Manager application core.             ");
			System.out.println("- node add <type> <index> [x] [y]                               ");
			System.out.println("      Create a new node with new type and index to Map, optional");
			System.out.println("      coordinates, randomly generated if not specified in cmd.  ");
			System.out.println("- node remove <index>                                           ");
			System.out.println("      Removes the node form Map with specified index.           ");
			System.out.println("- contact add <name> <age>                                      ");
			System.out.println("      Create a contact with specified name and age to the global");
			System.out.println("      community. Can be later called to choose apartment or pay ");
			System.out.println("      bills using reports and invoices.                         ");
			System.out.println("- contact remove <name>                                         ");
			System.out.println("      Removes the contact from the global community by name.    ");
			System.out.println("- contact choose_apartment <name|this>                          ");
			System.out.println("      Calls the contact to choose apartment. This operations is ");
			System.out.println("      equilvalent to calling a person to move in an apartment.  ");
			System.out.println("- report print <thing: line/contact> [target]                   ");
			System.out.println("      Calls the report generating component to generate a part /");
			System.out.println("      a section of report component. Useful for print files or  ");
			System.out.println("      inspecting element attributes via console.                ");
			System.out.println("- get <entity: route> <insight: path/cost>                      ");
			System.out.println("      Namely to get information of a certain entity and get its ");
			System.out.println("      insights, or useful datum, via on-screen display.         ");
			System.out.println("- help                                                          ");
			System.out.println("- ?                                                             ");
			System.out.println("-     Print this help page again.                               ");
			System.out.println("- undo                                                          ");
			System.out.println("- redo                                                          ");
			System.out.println("      Step forward or backward any qualified operations.        ");
			System.out.println("- ^C                                                            ");
			System.out.println("- exit                                                          ");
			System.out.println("      Quits this application. Ends the control session.         ");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			break;
		}
		default:
			System.out.println("Unknown operation: " + cmd);
			break;
		}

		if (qualifyUndo) {
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
		System.out.println("Undo " + c.getClass().getName() + ".");
		c.undo();
		historyUndo.add(c);
		historyDone.remove(historyDone.size() - 1);
		return c;
	}

	public static Command redo() {
		Command c = historyUndo.get(historyUndo.size() - 1);
		System.out.println("Redo " + c.getClass().getName() + ".");
		c.redo();
		historyDone.add(c);
		historyUndo.remove(historyUndo.size() - 1);
		return c;
	}

	private static void resetRedo() {
		historyUndo.clear();
	}
}
