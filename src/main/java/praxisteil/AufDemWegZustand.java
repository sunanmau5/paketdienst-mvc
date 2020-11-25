package praxisteil;

import java.util.Random;

public class AufDemWegZustand implements Zustand {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String sendungsverfolgung(Paket paket) {
		return "auf dem Weg";
	}

	@Override
	public void naechsterLieferschritt(Paket paket) {
		int random = (new Random()).nextInt(101);
		if (random > 50) {
			paket.setZustand(new AngekommenZustand());
		}
	}

	@Override
	public boolean isAngekommen(Paket paket) {
		return false;
	}

}
