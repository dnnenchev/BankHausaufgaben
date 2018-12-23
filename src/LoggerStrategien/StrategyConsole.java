package LoggerStrategien;

import Nenchev_s0566298_Kontoverwaltung.Konto;
import Nenchev_s0566298_Kontoverwaltung.Konto.OperationType;

public class StrategyConsole implements IExportStrategy {

	/**
	 * @param konto
	 * @return String
	 */
	@Override
	public String export(Konto konto) {
		String operation = konto.getLastOperationType() == OperationType.Einzahlung ? "Einzahlung" : "Auszahlung";

		return String.format("OperationType: %s, IBAN: %s, Amount: %s", operation, konto.getiBan(),
				konto.getLastOperationAmount());
	}

}
