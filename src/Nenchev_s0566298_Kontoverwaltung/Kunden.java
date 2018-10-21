package Nenchev_s0566298_Kontoverwaltung;

import java.util.ArrayList;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, E-Mail
 *         s0566298@htw-berlin.de
 *
 */
public class Kunden {
	/**
	 * Atributte
	 */
	private int kundenummer;
	private long telefonnummer;
	private String vorname;
	private String nachname;
	private String guburtsdatum;
	private String adresse;
	private String eMailAdresse;

	private Anrede anrede;

	private ArrayList<Konto> kontos;

	/**
	 * @param kundenummer
	 * @param vorname
	 * @param nachname
	 * @param guburtsdatum
	 * @param adresse
	 * @param telefonnummer
	 * @param eMailAdresse
	 */
	public Kunden(int kundenummer, String vorname, String nachname, String guburtsdatum, String adresse,
			long telefonnummer, String eMailAdresse) {
		this.kundenummer = kundenummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.guburtsdatum = guburtsdatum;
		this.adresse = adresse;
		this.telefonnummer = telefonnummer;
		this.eMailAdresse = eMailAdresse;
		this.kontos = new ArrayList<>();
	}

	/**
	 * 
	 * @param Konto
	 */
	public void addKonto(Konto kontos) {
		this.kontos.add(kontos);
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
	 * @return Vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param Set
	 *            Vorname
	 * 
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return Nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @param Set
	 *            Nachname
	 * 
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
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

	/**
	 * @return Anrede
	 */
	public Anrede getAnrede() {
		return anrede;
	}

	/**
	 * @param Set
	 *            Anrede
	 * 
	 */
	public void setAnrede(Anrede anrede) {
		this.anrede = anrede;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\n" + "Kundennummer : " + " " + kundenummer + " \n" + "Anrede : " + " " + anrede + "\n " + "Vorname : "
				+ vorname + "\n " + "Nachname : " + " " + nachname + "\n " + "Geburtsdatum : " + " " + guburtsdatum
				+ "\n " + "Adresse : " + " " + adresse + " \n" + "Telefonnummer : " + " " + telefonnummer + "\n "
				+ "E-Mail Adresse:  " + " " + eMailAdresse + "\n" + this.kontos.toString() + "\n";
	}

}
