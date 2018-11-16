package cs3343_core;

public class CmdReportPrintContacts extends Command {

	public CmdReportPrintContacts(Contacts c) {
		System.out.println(Report.getSectionContact(c));
	}

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}


}
