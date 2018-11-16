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

		Console.exec("report print line");
		for (int i = 0; i < 10; i++) {
			System.out.print("contact add Contact_" + i + " " + (int) Math.random() * 100 % 90);
			Console.exec("contact add Contact_" + i + " " + (int) Math.random() * 100 % 90);
			Console.exec("contact choose_apartment this");
			Console.exec("report print contact this");
		}
		
	}
}
