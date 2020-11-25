package praxisteil;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface Beobachter extends PropertyChangeListener {

	@Override
	default void propertyChange(PropertyChangeEvent evt) {
		Paket p = (Paket) evt.getSource();
		String geaendert = evt.getPropertyName();
		Object alt = evt.getOldValue();
		Object neu = evt.getNewValue();

		System.out.println("Änderung an Zustellungsphase einer Paket von " + p.getEmpfaenger() + " vorgenommen."
				+ System.lineSeparator() + geaendert + " wurde von " + alt.getClass() + " auf " + neu.getClass() + " gesetzt.");
	}
}
