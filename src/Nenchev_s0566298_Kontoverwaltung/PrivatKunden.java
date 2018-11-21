package Nenchev_s0566298_Kontoverwaltung;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, <s0566298@htw-berlin.de>
 *
 */

public class PrivatKunden extends Kunden {

	/**
	 * Atributte
	 */
	private String vorname;
	private String nachname;

	private Anrede anrede;

	/**
	 * 
	 * @param kundenummer
	 * @param vorname
	 * @param nachname
	 * @param guburtsdatum
	 * @param adresse
	 * @param telefonnummer
	 * @param eMailAdresse
	 * @param anrede
	 */
	public PrivatKunden(int kundenummer, String vorname, String nachname, String guburtsdatum, String adresse,
			long telefonnummer, String eMailAdresse, Anrede anrede) {
		super(kundenummer, guburtsdatum, adresse, telefonnummer, eMailAdresse);

		this.vorname = vorname;
		this.nachname = nachname;
		this.anrede = anrede;
	}

	// Überschreibene Methode

	@Override
	public String getName() {
		return this.vorname + " " + this.nachname;
	}

}