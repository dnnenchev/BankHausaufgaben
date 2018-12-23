package Nenchev_s0566298_Kontoverwaltung;

import java.util.Observable;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, <s0566298@htw-berlin.de>
 *
 */
public class Konto extends Observable {

	public enum OperationType {
		Unknown, Einzahlung, Auszahlung
	}

	/**
	 * Atributte
	 */
	private String iBan;

	private double kontoStand;

	private double mLastOperationAmount;

	private OperationType mIsLastOperationType;

	/**
	 * @param iBan
	 * @param kontoStand
	 */
	public Konto(String iBan, double kontoStand) {
		this.iBan = iBan;
		this.kontoStand = kontoStand;
		this.mLastOperationAmount = 0;
		this.mIsLastOperationType = OperationType.Unknown;
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
	 * 
	 * @return getLastOperationAmount gibt zurueck dem Betrag, den zuletzt
	 *         Ein/Ausgezahlt wurde
	 */
	public double getLastOperationAmount() {
		return mLastOperationAmount;
	}

	public OperationType getLastOperationType() {
		return mIsLastOperationType;
	}

	/**
	 * @param Set
	 *            Kontostand
	 * 
	 */
	public void setKontoStand(double kontoStand) {
		this.kontoStand = kontoStand;
	}

	public void geldEinzahlen(double betrag) {
		mIsLastOperationType = OperationType.Einzahlung;

		mLastOperationAmount = betrag;
		this.kontoStand += betrag;

		setChanged();
		notifyObservers(betrag >= 10000);
	}

	public void geldAuszahlhne(double betrag) {
		mIsLastOperationType = OperationType.Auszahlung;

		mLastOperationAmount = betrag;
		this.kontoStand -= betrag;

		setChanged();
		notifyObservers(betrag >= 10000);
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
