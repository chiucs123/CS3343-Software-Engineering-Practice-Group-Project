package cs3343_core.console;

import cs3343_core.Contacts;
import cs3343_core.Report;

public class CmdReportPrintContacts extends Command {

	public CmdReportPrintContacts(Contacts c) {
		System.out.println(Report.getSectionContact(c));
		System.out.println(Report.getSectionUsage(c));
	}

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}

}
