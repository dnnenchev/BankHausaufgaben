package Nenchev_s0566298_Kontoverwaltung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author Damyan Nenchev, Matrikelnummer: s0566298, <s0566298@htw-berlin.de>
 * 
 *
 */

public class Setup {

	private static Bank bank;

	private static Scanner scan;

	public static void initialSetup(Scanner scanner) {
		scan = scanner;

		/**
		 * Angaben der Bank
		 */
		bank = new Bank("Post Bank", 10010010, "PBNKDEFF", "An der Eule 5");
		Adresse adresse = new Adresse(105732, "Deutschland : Berlin");
	}

	/**
	 * @param showMenue
	 *            Start Menü
	 */
	public static void showMenu() {
		System.out.println("1. Privatkunde anlegen");
		System.out.println("2. Geschäftskunde anlegen");
		System.out.println("3. Konto anlegen und Kundennummer zuordnen");
		System.out.println("4. Kunde mit Konten anzeigen (Auswahl durch)");
		System.out.println("5. Kunde mit Konten anzeigen (Auswahl durch Name)");
		System.out.println("6. Konto anzeigen (Auswahl durch IBAN)");
		System.out.println("7. Alle Kunden sortieren nach aufsteigender Kundenummer anzeigen");
		System.out.println(
				"8. Alle Kunden sortieren nach aufsteigender Nachname und nachraging nach aufsteigenden Vornamen anzeigen ");
		System.out.println("9. Alle Konten unsortiert anzeigen");
		System.out.println("10. Beenden");
	}

	/**
	 * 
	 * @param Option
	 *            der Benutzer kann aus der Menüoptionen waehlen
	 */
	public static void handleOption(int option) {
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
		case 7: {
			sortKundeNummer();
		}

		case 8: {
			sortiereNachNamen();
		}

		case 9: {
			unsortierendetKonten();
		}

		}
	}

	/**
	 * @param addPrivatKunde
	 *            Privatkunde hinzufügen erste Option aus der Menü
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
	 * @param addFirmenKunde
	 *            Geschäftskunden hinzufügen
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
	 * @param addKontoAndSort
	 *            dritte Option aus der Menü
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
	 * @param kundeByNummer
	 *            Kunde durch Kundennummer auswählen
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
	 * @param kundeByName
	 *            Kunde durch Name auswählen
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
	 * @param kontoByIban
	 *            Auswahl der Konten durch IBAN
	 */
	private static void kontoByIban() {
		String iban = scan.nextLine();

		Konto konto = null;

		for (Kunden kunden : bank.getKundeList()) {
			if (kunden.getKontos().containsKey(iban)) {
				konto = kunden.getKontos().get(iban);
				break;
			}
		}

		if (konto == null) {
			System.out.println("No konto for iban found");
		} else {
			System.out.println(konto.toString());
		}
	}

	/**
	 * @param sortKundeNummer
	 *            Kundenummer aufsteigend sortieren
	 */
	private static void sortKundeNummer() {
		ArrayList<Kunden> sortedKunden = bank.getKundeList();

		sortedKunden.sort(new Comparator<Kunden>() {

			@Override
			public int compare(Kunden kunden1, Kunden kunden2) {
				return kunden1.getKundenummer() < kunden2.getKundenummer() ? 1 : 0;
			}

		});

		for (Kunden kunden : sortedKunden) {
			System.out.println(kunden.toString());
		}
	}

	/**
	 * @param sortiereNachNamen
	 *            Namer der Kunde aufsteigend und nachranging sortieren
	 */
	private static void sortiereNachNamen() {
		ArrayList<Kunden> sortedKunden = new ArrayList<>();

		sortedKunden.sort(new Comparator<Kunden>() {

			@Override
			public int compare(Kunden kunden1, Kunden kunden2) {
				return kunden1.getName().compareTo(kunden2.getName());
			}

		});

		for (Kunden kunden : sortedKunden) {
			System.out.println(kunden.toString());
		}
	}

	/**
	 * @param unsortierendeKonten
	 *            Konten unsortiert anzeigen
	 */
	private static void unsortierendetKonten() {
		ArrayList<Kunden> shuffledKunden = bank.getKundeList();

		Collections.shuffle(shuffledKunden);

		for (Kunden kunden : shuffledKunden) {
			System.out.println(kunden.toString());
		}
	}

}
