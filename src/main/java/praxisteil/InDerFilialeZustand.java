package praxisteil;

public class InDerFilialeZustand implements Zustand {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String sendungsverfolgung(Paket paket) {
		return "in der Filiale";
	}

	@Override
	public void naechsterLieferschritt(Paket paket) {
		paket.setZustand(new AufDemWegZustand());
	}

	@Override
	public boolean isAngekommen(Paket paket) {
		return false;
	}

}
