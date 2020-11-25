package praxisteil;

public class AngekommenZustand implements Zustand {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String sendungsverfolgung(Paket paket) {
		return "angekommen";
	}

	@Override
	public void naechsterLieferschritt(Paket paket) {
	}

	@Override
	public boolean isAngekommen(Paket paket) {
		return true;
	}

}
