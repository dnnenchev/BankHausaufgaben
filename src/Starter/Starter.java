package Starter;

import java.util.Scanner;

import Nenchev_s0566298_Kontoverwaltung.Setup;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, <s0566298@htw-berlin.de>
 *
 */
public class Starter {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		Setup.initialSetup(scan);

		int option = -1;
		/**
		 * Falsche Option ausgewählt aus der Menü
		 */
		do {
			Setup.showMenu();

			option = Integer.parseInt(scan.nextLine());

			if (option < 1 || option > 7) {
				System.out.println("\nInvalid option\n");
			} else {
				Setup.handleOption(option);
			}
		} while (option != 10);

	}
}
