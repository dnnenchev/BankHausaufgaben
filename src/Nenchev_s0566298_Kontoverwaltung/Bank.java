package Nenchev_s0566298_Kontoverwaltung;

import java.util.ArrayList;

import rechtsabteilung.Bankangestellten;
import rechtsabteilung.Vorstand;

/**
 * 
 * @author Damyan Nenchev ,Matrikelnummer: S0566298, E-Mail
 *         s0566298@htw-berlin.de
 *
 */
public class Bank {
	/**
	 * Atributte
	 */
	private int blz;

	private String name;
	private String bic;
	private String adresse;

	private ArrayList<Vorstand> vorstandList;
	private ArrayList<Bankangestellten> bankangestelltenList;

	private ArrayList<Kunden> kunde;

	/**
	 * @param name
	 * @param blz
	 * @param bic
	 * @param adresse
	 */
	public Bank(String name, int blz, String bic, String adresse) {
		this.name = name;
		this.blz = blz;
		this.bic = bic;
		this.adresse = adresse;
		this.kunde = new ArrayList<>();
		this.vorstandList = new ArrayList<>();
		this.bankangestelltenList = new ArrayList<>();

		seedKunden();
		seedVorstand();
		seedBankangestellten();
	}

	public void addKunden(Kunden kunden) {
		this.kunde.add(kunden);
	}

	/**
	 * @return Die Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param Set
	 *            die Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Bankleitzahl
	 */
	public int getBlz() {
		return blz;
	}

	/**
	 * @param Set
	 *            Bankleitzahl
	 * 
	 */
	public void setBlz(int blz) {
		this.blz = blz;
	}

	/**
	 * @return BIC
	 */
	public String getBic() {
		return bic;
	}

	/**
	 * @param Set
	 *            BIC
	 * 
	 */
	public void setBic(String bic) {
		this.bic = bic;
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
	 * 
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @param Set
	 *            Adresse
	 * 
	 */
	public ArrayList<Kunden> getKundeList() {
		return this.kunde;
	}

	public ArrayList<Vorstand> getVorstandList() {
		return this.vorstandList;
	}

	public ArrayList<Bankangestellten> getBankangestelltenList() {
		return this.bankangestelltenList;
	}

	private void seedKunden() {
		kunde.add(new PrivatKunden(123, "Viktor", "Georgiev", "19.12.1995", "Burghardstr. 3", 123445456,
				"dnnenchev@gmail.com", Anrede.Herr));
	}

	private void seedVorstand() {
		vorstandList.add(new Vorstand("Damyan", "Nenchev"));
	}

	private void seedBankangestellten() {
		bankangestelltenList.add(new Bankangestellten("Ivan", "Ivanov"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bankname : " + name + "\n" + "Bankleitzahl : " + blz + "\n" + "BIC : " + bic + "\n" + "Adresse : "
				+ adresse + "\n\n" + String.join("\n", this.kunde.toString());
	}

}
