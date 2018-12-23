package rechtsabteilung;

import java.util.Observable;
import java.util.Observer;

import LoggerStrategien.Logger;
import Nenchev_s0566298_Kontoverwaltung.Konto;

public class Bankangestellten extends Observable implements Observer {

	private String mVorname;
	private String mNachname;

	public Bankangestellten(String vorname, String nachname) {
		this.mVorname = vorname;
		this.mNachname = nachname;
	}

	@Override
	public void update(Observable observable, Object obj) {
		if (observable instanceof Konto) {
			Logger.getInstance().logTransaction(getFullName(), (Konto) observable, false);
		}
	}

	private String getFullName() {
		return String.format("%s %s", mVorname, mNachname);
	}

}
