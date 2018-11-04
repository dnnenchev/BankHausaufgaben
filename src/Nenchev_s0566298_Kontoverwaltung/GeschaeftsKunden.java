package Nenchev_s0566298_Kontoverwaltung;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, <s0566298@htw-berlin.de>
 *
 */

public class GeschaeftsKunden extends Kunden {

	/**
	 * Atributte
	 */
	private String firmenName;

	/**
	 * 
	 * @param kundenummer
	 * @param firmenName
	 * @param guburtsdatum
	 * @param adresse
	 * @param telefonnummer
	 * @param eMailAdresse
	 */
	public GeschaeftsKunden(int kundenummer, String firmenName, String guburtsdatum, String adresse, long telefonnummer,
			String eMailAdresse) {
		super(kundenummer, guburtsdatum, adresse, telefonnummer, eMailAdresse);

		this.firmenName = firmenName;
	}

	// Überschreibene Methode
	@Override
	public String getName() {
		return this.firmenName;
	}

}
