package Nenchev_s0566298_Kontoverwaltung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, <s0566298@htw-berlin.de>
 *
 */
public abstract class Kunden {
	/**
	 * Atributte
	 */
	private int kundenummer;
	private long telefonnummer;

	private String guburtsdatum;
	private String adresse;
	private String eMailAdresse;

	private ArrayList<Konto> kontos;

	/**
	 * @param kundenummer
	 * @param guburtsdatum
	 * @param adresse
	 * @param telefonnummer
	 * @param eMailAdresse
	 */
	public Kunden(int kundenummer, String guburtsdatum, String adresse, long telefonnummer, String eMailAdresse) {
		this.kundenummer = kundenummer;
		this.guburtsdatum = guburtsdatum;
		this.adresse = adresse;
		this.telefonnummer = telefonnummer;
		this.eMailAdresse = eMailAdresse;
		this.kontos = new ArrayList<>();
	}

	// Abstracte Methode
	public abstract String getName();

	/**
	 * 
	 * @param Konto
	 */
	public void addKonto(Konto kontos) {
		this.kontos.add(kontos);
	}

	public ArrayList<Konto> getKontos() {
		return this.kontos;
	}

	/**
	 * @return Kundennummer
	 */
	public int getKundenummer() {
		return kundenummer;
	}

	/**
	 * @param Set
	 *            Kundennummer
	 * 
	 */
	public void setKundenummer(int kundenummer) {
		this.kundenummer = kundenummer;
	}

	/**
	 * @return Geburtsdatum
	 */
	public String getGuburtsdatum() {
		return guburtsdatum;
	}

	/**
	 * @param Set
	 *            Geburtsdatum
	 * 
	 */
	public void setGuburtsdatum(String guburtsdatum) {
		this.guburtsdatum = guburtsdatum;
	}

	/**
	 * @return Adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param Set
	 *            Adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return Telefonnummer
	 */
	public long getTelefonnummer() {
		return telefonnummer;
	}

	/**
	 * @param Set
	 *            Telefonnummerr
	 * 
	 */
	public void setTelefonnummer(long telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	/**
	 * @return E-Mail Adresse
	 */
	public String geteMailAdresse() {
		return eMailAdresse;
	}

	/**
	 * @param Set
	 *            E-Mail Adresse
	 * 
	 */
	public void seteMailAdresse(String eMailAdresse) {
		this.eMailAdresse = eMailAdresse;
	}

	public void sortKontos() {
		Collections.sort(kontos, new Comparator<Konto>() {

			public int compare(Konto konto1, Konto konto2) {
				return konto1.getKontoStand() < konto2.getKontoStand() ? 1 : 0;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\n" + "Kundennummer : " + " " + kundenummer + " \n" + "Geburtsdatum : " + " " + guburtsdatum + "\n "
				+ "Adresse : " + " " + adresse + " \n" + "Telefonnummer : " + " " + telefonnummer + "\n "
				+ "E-Mail Adresse:  " + " " + eMailAdresse + "\n" + this.kontos.toString() + "\n";
	}

}
