package Nenchev_s0566298_Kontoverwaltung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class BankOutput {

	// Erstellung von Dateien mit Exception Input Output
	public static void writeBank(String dateiname, Bank bank) {

		File datei = new File(dateiname);
		if (datei.exists()) {
			System.out.println("Die Datei existiert bereits und wird versucht zu Ueberschreiben");
		}

		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(dateiname);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(bank);
		} catch (IOException e) {
			System.out.println("Es ist ein Fehler beim Schreiben der Daten aufgetreten.");
			e.printStackTrace();
		}

		if (objectOutputStream != null) {
			try {
				objectOutputStream.close();
			} catch (IOException e) {
				System.out.println("Es ist ein Fehler beim Schließen es Streams aufgetreten.");
				e.printStackTrace();
			}
		}
	}

	// Lies der Dateie
	public static Bank readBank(String dateiname) {
		File datei = new File(dateiname);
		if (!datei.exists() || !datei.canRead()) {
			System.out.println("Die Datei existiert nicht oder kann nicht gelesen werden.");
		}

		Bank bank = null;

		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = new FileInputStream(dateiname);
			objectInputStream = new ObjectInputStream(fileInputStream);
			bank = (Bank) objectInputStream.readObject();
		} catch (IOException e) {
			System.out.println("Es ist ein Fehler beim Schreiben der Daten aufgetreten.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Es ist ein Fehler beim Schreiben der Daten aufgetreten.");
			e.printStackTrace();
		}

		if (objectInputStream != null) {
			try {
				objectInputStream.close();
			} catch (IOException e) {
				System.out.println("Es ist ein Fehler beim Schließen es Streams aufgetreten.");
				e.printStackTrace();
			}
		}

		return bank;
	}

	// Schreib Datei mit Kunden
	public static void writeKunden(String dateiname, Bank bank) {
		PrintWriter out;

		try {
			out = new PrintWriter(dateiname);

			for (Kunden kunde : bank.getKundeList()) {
				out.print(kunde.getKundenummer() + ";");
				out.print(kunde.getKundenTyp() + ";");
				out.print(kunde.getName() + ";");

				for (Konto konto : kunde.getKontos().values()) {
					out.println(konto.getKontoStand() + ";");
				}
			}

			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
