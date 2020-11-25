package praxisteil;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * ein Paket, das zum gespeicherten Empf�nger gebracht werden soll
 *
 */
public class Paket implements Serializable {
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 12141L;
	private String empfaenger;
	private Zustand aktuell = new InDerFilialeZustand();
	private PropertyChangeSupport prop = new PropertyChangeSupport(this);
	private List<Beobachter> beobachterliste = new LinkedList<>();
	
	/**
	 * Empf�nger des Paketes
	 * 
	 * @return Empf�nger
	 */
	public String getEmpfaenger() {
		return empfaenger;
	}

	/**
	 * erstellt ein Paket f�r den angegebenen Empf�nger
	 * 
	 * @param empfaenger darf nicht null sein
	 */
	public Paket(String empfaenger, PaketdienstController con) {
		if (empfaenger == null)
			empfaenger = "unbekannt";
		this.empfaenger = empfaenger;
		beobachterliste.add(con);
		anmelden(con);
	}

	/**
	 * liefert eine Aussage, wo das Paket gerade ist
	 * 
	 * @return
	 */
	public String sendungsverfolgung() {
		return aktuell.sendungsverfolgung(this);
	}

	/**
	 * macht den nächsten Lieferschritt f�r das Paket
	 */
	public void naechsterLieferschritt() {
		Zustand neu = this.aktuell;
		aktuell.naechsterLieferschritt(this);
		prop.firePropertyChange("Zustellungsphase", neu, aktuell);
	}

	/**
	 * gibt zur�ck, ob das Paket bereits beim Empf�nger angekommen ist
	 * 
	 * @return
	 */
	public boolean isAngekommen() {
		return aktuell.isAngekommen(this);
	}

	/**
	 * ersetzt den aktuellen Zustand mit dem neuen Zustand
	 * 
	 * @param state der neue Zustand
	 */
	void setZustand(Zustand state) {
		if (aktuell != null) {
			aktuell = state;
		}
	}

	/**
	 * Fuegt den Beobachter b in die Liste
	 * 
	 * @param b Beobachter
	 */
	public void anmelden(PropertyChangeListener l) {
		prop.addPropertyChangeListener(l);
	}

	/**
	 * Loescht den Beobachter von der Liste
	 * 
	 * @param b Beobachter
	 */
	public void abmelden(PropertyChangeListener l) {
		prop.removePropertyChangeListener(l);
	}

	/**
	 * benachrichtigt alle Beobachter in der Liste
	 */
	protected void firePropertyChange(String name, Object alt, Object neu) {
		prop.firePropertyChange(name, alt, neu);
	}

}
