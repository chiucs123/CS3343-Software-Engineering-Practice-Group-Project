package cs3343_core;

public class Main {

	public static void main(String args[]) {
		System.out.println("Welcome to CS3343 Software Engineering Practice Group Project.");
		Console.exec("start");
		Console.exec("start");
		Console.exec("get route path a d");
		Console.exec("this");
		Console.exec("get route cost e f");
		Console.exec("this");

		Report.printLine();
		for (int i = 0; i < 10; i++) {
			Contacts c = new Contacts("Contact_" + i, (int) Math.random() * 100 % 90);
			c.chooseApartment();
			System.out.println(Report.getSectionContact(c));
		}

	}
}
