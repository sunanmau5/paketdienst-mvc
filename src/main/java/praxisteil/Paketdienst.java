package praxisteil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stellt einen Lieferdienst f�r Pakete dar
 *
 */
public class Paketdienst implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 12014L;
	
	private List<Paket> paketliste = new ArrayList<>();
	private String name = "Dänischer Hochschul-Logistiker";

	/**
	 * der Name des Paketdienstes
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * beginnt die Zustellung des Paketes in der Filiale des Paketdienstes
	 * 
	 * @param p
	 */
	public void paketBringen(Paket p) {
		paketliste.add(p);
		zustellen(p);
	}

	/**
	 * die eigentliche Zustellung des Paketes
	 * 
	 * @param p
	 */
	private void zustellen(Paket p) {
		Thread t = new Thread(() -> {
			while (!p.isAngekommen()) {
				p.naechsterLieferschritt();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		});
		t.start();
	}

	/**
	 * liefert eine alphabetisch sortierte Liste aller Paketempf�nger
	 * 
	 * @return
	 */
	public String getEmpfaengerliste() {
		String empfaengerListe = paketliste.stream().map(p -> p.getEmpfaenger()).sorted().collect(Collectors.toList())
				.toString();
		return empfaengerListe;
	}

	public void speichern(String dateiname) throws Exception {
		// Serialisierung von Objekt
		FileOutputStream fos = new FileOutputStream(dateiname);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(this);
		out.close();

		// Deserialisierung von Objekt
		FileInputStream fis = new FileInputStream(dateiname);
		ObjectInputStream in = new ObjectInputStream(fis);
		Paketdienst pd = (Paketdienst) in.readObject();
		in.close();
	}

}
