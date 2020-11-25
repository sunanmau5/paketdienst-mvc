package praxisteil;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * verwaltet einen Paketdienst
 *
 */
public class PaketdienstController extends Application implements Beobachter {

	@FXML
	private Label lblSendungsverfolgung;
	@FXML
	private TextField txtEmpfaenger;
	@FXML
	Label lblPaketliste;
	@FXML
	private Paketdienst dhl = new Paketdienst();

	private Stage stage;

	/**
	 * h�ngt die angegebene Nachricht an das Feld lblSendungsverfolgung an
	 * 
	 * @param nachricht
	 */
	private void labelAktualisieren(String nachricht) {
		Platform.runLater(() -> lblSendungsverfolgung
				.setText(lblSendungsverfolgung.getText() + System.lineSeparator() + nachricht));
	}

	/**
	 * behandelt den Button "Paket aufgeben"
	 */
	public void paketAufgeben() {
		String empfaenger = txtEmpfaenger.getText();
		Paket p = new Paket(empfaenger, this);
		dhl.paketBringen(p);
		lblPaketliste.setText(dhl.getEmpfaengerliste());
		labelAktualisieren(p.sendungsverfolgung());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../PaketdienstOberflaeche.fxml"));
		loader.setController(this);
		Parent lc = loader.load();
		Scene scene = new Scene(lc, 800, 400);
		stage.setTitle("Paketdienst");
		stage.setScene(scene);
		stage.show();
	}
}
