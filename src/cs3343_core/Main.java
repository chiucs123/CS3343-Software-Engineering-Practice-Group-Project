package cs3343_core;

import java.util.Scanner;

import cs3343_core.console.*;

public class Main {

	public static void main(String args[]) {
		System.out.println("Welcome to CS3343 Software Engineering Practice Group Project.");

		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("> ");
			String s = in.nextLine();
			if (s.trim().toLowerCase().equals("exit")) {
				System.out.println("Bye!");
				in.close();
				return;
			} else {
				Console.exec(s.trim());
			}
		}
		
	}
}
