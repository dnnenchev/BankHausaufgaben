package Nenchev_s0566298_Kontoverwaltung;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, <s0566298@htw-berlin.de>
 */
public class Adresse {
	/**
	 * Atributte
	 */
	protected int postleitzahl;
	protected String ort;

	/**
	 * @param postleitzahl
	 * @param ort
	 */
	public Adresse(int postleitzahl, String ort) {
		this.postleitzahl = postleitzahl;
		this.ort = ort;
	}

	/**
	 * @return Postleitzahl
	 */
	public int getPostleitzahl() {
		return postleitzahl;
	}

	/**
	 * @param Set
	 *            Die Postleitzahl
	 * 
	 */
	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	/**
	 * @return Ort
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * @param Set
	 *            Ort
	 * 
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PLZ : " + " " + postleitzahl + "\n" + ort;
	}

}
