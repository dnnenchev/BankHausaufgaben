package rechtsabteilung;

import java.util.Observable;
import java.util.Observer;

import LoggerStrategien.Logger;
import Nenchev_s0566298_Kontoverwaltung.Konto;

public class Vorstand implements Observer {

	private String mVorname;
	private String mNachname;

	public Vorstand(String vorname, String nachname) {
		this.mVorname = vorname;
		this.mNachname = nachname;
	}

	@Override
	public void update(Observable observable, Object obj) {
		if (observable instanceof Konto) {
			if (obj instanceof Boolean) {
				if ((boolean) obj) {
					Logger.getInstance().logTransaction(getFullName(), (Konto) observable, true);
				}
			}
		}
	}

	private String getFullName() {
		return String.format("%s %s", mVorname, mNachname);
	}

}
