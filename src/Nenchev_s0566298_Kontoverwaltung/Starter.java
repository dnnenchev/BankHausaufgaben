package Starter;

import Nenchev_s0566298_Kontoverwaltung.Adresse;
import Nenchev_s0566298_Kontoverwaltung.Anrede;
import Nenchev_s0566298_Kontoverwaltung.Bank;
import Nenchev_s0566298_Kontoverwaltung.Konto;
import Nenchev_s0566298_Kontoverwaltung.Kunden;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, E-Mail
 *         s0566298@htw-berlin.de
 *
 */
public class Starter {

	public static void main(String[] args) {
		/**
		 * Angaben der Bank
		 */
		Bank bankdaten = new Bank("Post Bank", 10010010, "PBNKDEFF", "An der Eule 5");
		Adresse adresse = new Adresse(105732, "Deutschland : Berlin");

		Kunden kundendaten1 = new Kunden(566298, "Tomas", "Mueler", "19.12.1995", "Friedrichsgracht 57", 1765432177,
				"tomas@gmail.com");
		Kunden kundendaten2 = new Kunden(385412, "Yana", "Hagel", "03.02.1972", "Friesweg 4", 178105532,
				"yana.hagel@gmx.de");
		Kunden kundendaten3 = new Kunden(249310, "Maria", "Obuslavski", "13.06.1958", "Am Planetarium 7", 1759112778,
				"russiangirl@gmail.com");
		Kunden kundendaten4 = new Kunden(321123, "Helmut", "Flicker", "17.11.1990", "Strochstraße 51", 1769338157,
				"flicker_29@gmail.com");
		Kunden kundendaten5 = new Kunden(614888, "Charls", "Heminguey", "23.03.1983", "Felixstraße 69", 1767753326,
				"ch_heming@gmail.com");

		kundendaten1.setAnrede(Anrede.Herr);
		kundendaten2.setAnrede(Anrede.Frau);
		kundendaten3.setAnrede(Anrede.Frau);
		kundendaten4.setAnrede(Anrede.Herr);
		kundendaten5.setAnrede(Anrede.Herr);
		/**
		 * jeweils 0 bis 3 Konten hinfuegen
		 */
		kundendaten1.addKonto(new Konto("DE57 1160 1688 8800 5521 00", 1.500));
		kundendaten1.addKonto(new Konto("DE40 2931 2341 4320 7891 00", 35.500));
		kundendaten1.addKonto(new Konto("DE00 1234 3321 7189 4789 00", 2.356));

		kundendaten2.addKonto(new Konto("DE15 7162 7823 4319 9921 00", 23.319));

		kundendaten3.addKonto(new Konto("DE11 1289 2572 0134 9311 00", 2.839));
		kundendaten3.addKonto(new Konto("DE05 0032 5661 9333 9512 00", 5.451));

		kundendaten4.addKonto(new Konto("DE02 9677 8311 0504 3181 00", 7.500));

		kundendaten5.addKonto(new Konto("DE88 3197 0666 5781 8954 00", 0.750));
		kundendaten5.addKonto(new Konto("DE78 2177 9876 1289 8732 00", 45.800));
		/**
		 * 5 Kunden hinfuegen
		 */
		bankdaten.addKunden(kundendaten1);
		bankdaten.addKunden(kundendaten2);
		bankdaten.addKunden(kundendaten3);
		bankdaten.addKunden(kundendaten4);
		bankdaten.addKunden(kundendaten5);
		/**
		 * Ausgabe
		 */
		System.out.print(bankdaten);

	}

}
