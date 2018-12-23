package LoggerStrategien;

import Nenchev_s0566298_Kontoverwaltung.Konto;
import Nenchev_s0566298_Kontoverwaltung.Konto.OperationType;

public class StrategyCSV implements IExportStrategy {

	/**
	 * 
	 * 
	 * @param konto
	 * 
	 * @return String
	 */
	@Override
	public String export(Konto konto) {
		StringBuilder builder = new StringBuilder();

		String operation = konto.getLastOperationType() == OperationType.Einzahlung ? "Einzahlung" : "Auszahlung";

		builder.append(operation);
		builder.append(";");

		builder.append(konto.getiBan());
		builder.append(";");

		builder.append(konto.getLastOperationAmount());
		builder.append(";");
		builder.append("\n");

		return builder.toString();
	}

}
