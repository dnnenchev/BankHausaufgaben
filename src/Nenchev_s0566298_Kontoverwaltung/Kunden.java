package Nenchev_s0566298_Kontoverwaltung;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	private HashMap<String, Konto> kontos;

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
		this.kontos = new HashMap<>();
	}

	// Abstracte Methode
	public abstract String getName();

	/**
	 * 
	 * @param Konto
	 */
	public void addKonto(Konto konto) {
		if (!kontos.containsKey(konto.getiBan())) {
			kontos.put(konto.getiBan(), konto);
		}
	}

	public Map<String, Konto> getKontos() {
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
		kontos = sortByComparator(kontos);
	}

	private HashMap<String, Konto> sortByComparator(HashMap<String, Konto> unsortMap) {

		List<Entry<String, Konto>> list = new LinkedList<>(unsortMap.entrySet());

		Collections.sort(list, new Comparator<Entry<String, Konto>>() {
			public int compare(Entry<String, Konto> entry1, Entry<String, Konto> entry2) {
				return entry1.getValue().getKontoStand() < entry2.getValue().getKontoStand() ? 1 : 0;
			}
		});

		HashMap<String, Konto> sortedMap = new LinkedHashMap<String, Konto>();

		for (Entry<String, Konto> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
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
