package praxisteil;

import java.io.Serializable;

/**
 * Zustand Interface fuer Paketzustellung
 * 
 * @author Sunan Regi Maunakea
 *
 */
public interface Zustand extends Serializable {

	/**
	 * liefert eine Aussage, wo das Paket gerade ist
	 * 
	 * @param paket das Paket
	 * @return die Aussage
	 */
	public String sendungsverfolgung(Paket paket);

	/**
	 * macht den nächsten Lieferschritt fuer das Paket
	 * 
	 * @param das Paket
	 */
	public void naechsterLieferschritt(Paket paket);

	/**
	 * gibt zurueck, ob das Paket bereits beim Empfaenger angekommen ist
	 * 
	 * @param das Paket
	 * @return true, wenn Paket angekommen ist
	 */
	public boolean isAngekommen(Paket paket);
}
