package Nenchev_s0566298_Kontoverwaltung;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, <s0566298@htw-berlin.de>
 *
 */
public class Konto {
	/**
	 * Atributte
	 */
	private String iBan;
	private double kontoStand;

	/**
	 * @param iBan
	 * @param kontoStand
	 */
	public Konto(String iBan, double kontoStand) {
		this.iBan = iBan;
		this.kontoStand = kontoStand;
	}

	/**
	 * @return IBAN
	 */
	public String getiBan() {
		return iBan;
	}

	/**
	 * @param Set
	 *            IBAN
	 * 
	 */
	public void setiBan(String iBan) {
		this.iBan = iBan;
	}

	/**
	 * @return Kontostand
	 */
	public double getKontoStand() {
		return kontoStand;
	}

	/**
	 * @param Set
	 *            Kontostand
	 * 
	 */
	public void setKontoStand(double kontoStand) {
		this.kontoStand = kontoStand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IBAN: " + iBan + "\n" + "Kontostand : " + +kontoStand + "\n";
	}

}
