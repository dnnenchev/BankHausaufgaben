package LoggerStrategien;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

import Nenchev_s0566298_Kontoverwaltung.Konto;
import Nenchev_s0566298_Kontoverwaltung.Konto.OperationType;

public class Logger {

	/**
	 * Logger- Singelton
	 */
	private static Logger instance;

	/**
	 * Atributte
	 */
	private IExportStrategy strategy;

	private String mFileName;

	/**
	 * Konstruktor
	 */
	private Logger() {
		strategy = new StrategyConsole();
	}

	/**
	 * 
	 * @return instance
	 */
	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}

		return instance;
	}

	/**
	 * 
	 * @param name
	 * @param konto
	 * @param isVorstand
	 */
	public void logTransaction(String name, Konto konto, boolean isVorstand) {
		String operation = konto.getLastOperationType() == OperationType.Einzahlung ? "Einzahlung" : "Auszahlung";
		String position = isVorstand ? "Vorstand" : "Bankangestellten";

		if (!isVorstand) {
			logInConsole(konto);
			logInCsv(konto);
		}

		System.out.printf(
				"%s %s hat die Information erhalten, dass eine %s in Hoehe von %.2f Euro auf das Konto %s stattgefunden hat\n\n",
				position, name, operation, konto.getLastOperationAmount(), konto.getiBan());
	}

	/**
	 * 
	 * @param konto
	 */
	private void logInConsole(Konto konto) {
		if (strategy instanceof StrategyConsole) {
			System.out.printf("Time: %s, %s\n\n", getTime(), strategy.export(konto));
		}
	}

	/**
	 * 
	 * @param konto
	 */
	private void logInCsv(Konto konto) {
		if (strategy instanceof StrategyCSV) {
			if (mFileName == null) {
				System.out.print("Enter filename: ");
				mFileName = new Scanner(System.in).nextLine();
			}

			File csvFile = new File(mFileName);

			if (!csvFile.exists()) {
				try {
					csvFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			PrintWriter out;

			try {
				out = new PrintWriter(new FileOutputStream(csvFile, true));

				out.print(getTime());
				out.print(";");
				out.print(strategy.export(konto));

				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param strategy
	 */
	public void setStrategy(IExportStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.mFileName = fileName;
	}

	/**
	 * 
	 * @return getFileName
	 */
	public String getFileName() {
		return mFileName;
	}

	/**
	 * 
	 * @return getTime
	 */
	private String getTime() {
		return LocalDateTime.now().toString();
	}

}
