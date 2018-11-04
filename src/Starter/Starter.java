package Starter;

import java.util.Scanner;

import Nenchev_s0566298_Kontoverwaltung.Adresse;
import Nenchev_s0566298_Kontoverwaltung.Anrede;
import Nenchev_s0566298_Kontoverwaltung.Bank;
import Nenchev_s0566298_Kontoverwaltung.GeschaeftsKunden;
import Nenchev_s0566298_Kontoverwaltung.Konto;
import Nenchev_s0566298_Kontoverwaltung.Kunden;
import Nenchev_s0566298_Kontoverwaltung.PrivatKunden;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, <s0566298@htw-berlin.de>
 *
 */
public class Starter {

	private static Bank bank;

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		/**
		 * Angaben der Bank
		 */
		bank = new Bank("Post Bank", 10010010, "PBNKDEFF", "An der Eule 5");
		Adresse adresse = new Adresse(105732, "Deutschland : Berlin");

		int option = -1;
		/**
		 * Falsche Option ausgewählt aus der Menü
		 */
		do {
			showMenu();

			option = Integer.parseInt(scan.nextLine());

			if (option < 1 || option > 7) {
				System.out.println("\nInvalid option\n");
			} else {
				handleOption(option);
			}
		} while (option != 7);

	}

	/**
	 * Start Menü
	 */
	private static void showMenu() {
		System.out.println("1. Privatkunde anlegen");
		System.out.println("2. Geschäftskunde anlegen");
		System.out.println("3. Konto anlegen und Kundennummer zuordnen");
		System.out.println("4. Kunde mit Konten anzeigen (Auswahl durch)");
		System.out.println("5. Kunde mit Konten anzeigen (Auswahl durch Name)");
		System.out.println("6. Konto anzeigen (Auswahl durch IBAN)");
		System.out.println("7. Beenden");
	}

	/**
	 * 
	 * @param Option
	 */
	private static void handleOption(int option) {
		switch (option) {
		case 1: {
			addPrivatKunde();
		}
		case 2: {
			addFirmenKunde();
		}
		case 3: {
			addKontoAndSort();
		}
		case 4: {
			kundeByNummer();
		}
		case 5: {
			kundeByName();
		}
		case 6: {
			kontoByIban();
		}
		}
	}

	/**
	 * Privatkunde hinzufügen erste Option aus der Menü
	 */
	private static void addPrivatKunde() {
		int kundenNummer = Integer.parseInt(scan.nextLine());
		String vorname = scan.nextLine();
		String nachname = scan.nextLine();
		String geburdstadum = scan.nextLine();
		String addresse = scan.nextLine();
		long telefon = Long.parseLong(scan.nextLine());
		String email = scan.nextLine();
		Anrede anrede = Integer.parseInt(scan.nextLine()) == 0 ? Anrede.Herr : Anrede.Frau;

		bank.addKunden(
				new PrivatKunden(kundenNummer, vorname, nachname, geburdstadum, addresse, telefon, email, anrede));
	}

	/**
	 * Geschäftskunden hinzufügen
	 */
	private static void addFirmenKunde() {
		// kato dobavqne na private kunde, samo che obekta ot tip class
		// new GeschaeftsKunden
		int kundenNummer = Integer.parseInt(scan.nextLine());
		String firmenName = scan.nextLine();
		String geburdstadum = scan.nextLine();
		String addresse = scan.nextLine();
		long telefon = Long.parseLong(scan.nextLine());
		String email = scan.nextLine();

		bank.addKunden(new GeschaeftsKunden(kundenNummer, firmenName, geburdstadum, addresse, telefon, email));
	}

	/**
	 * dritte Option aus der Menü
	 */
	private static void addKontoAndSort() {
		int nummer = Integer.parseInt(scan.nextLine());

		Kunden kunde = null;

		for (Kunden kunden : bank.getKundeList()) {
			if (kunden.getKundenummer() == nummer) {
				kunde = kunden;
				break;
			}
		}

		if (kunde != null) {
			kunde.addKonto(new Konto(scan.nextLine(), Double.parseDouble(scan.nextLine())));
			kunde.sortKontos();
		}
	}

	/**
	 * Kunde durch Kundennummer auswählen
	 */
	private static void kundeByNummer() {
		int nummer = Integer.parseInt(scan.nextLine());

		Kunden kunde = null;

		for (Kunden kunden : bank.getKundeList()) {
			if (kunden.getKundenummer() == nummer) {
				kunde = kunden;
				break;
			}
		}

		if (kunde == null || kunde.getKontos().isEmpty()) {
			System.out.println("Kunde mit accountNummer not found");
		} else {
			System.out.println(kunde.toString());
		}
	}

	/**
	 * Kunde durch Name auswählen
	 */
	private static void kundeByName() {
		String name = scan.nextLine();

		Kunden kunde = null;

		for (Kunden kunden : bank.getKundeList()) {
			if (kunden.getName() == name) {
				kunde = kunden;
				break;
			}
		}

		if (kunde == null || kunde.getKontos().isEmpty()) {
			System.out.println("No client with kontos for this account number");
		} else {
			System.out.println(kunde.toString());
		}
	}

	/**
	 * Auswahl der Konten durch IBAn
	 */
	private static void kontoByIban() {
		String iban = scan.nextLine();

		Konto konto = null;

		for (Kunden kunden : bank.getKundeList()) {
			for (Konto kont : kunden.getKontos()) {
				if (kont.getiBan().equalsIgnoreCase(iban)) {
					konto = kont;
					break;
				}
			}
		}

		if (konto == null) {
			System.out.println("No konto for iban found");
		} else {
			System.out.println(konto.toString());
		}
	}

}
