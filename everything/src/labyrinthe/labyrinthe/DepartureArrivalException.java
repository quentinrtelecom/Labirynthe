package labyrinthe;

public class DepartureArrivalException extends Exception {

	private static final long serialVersionUID = 1L;

	
	/** L�ve une exception si le labyrinthe ne poss�de pas d'arriv�e ou de d�part
	 * 
	 */
	public DepartureArrivalException(String message) {
		super("Erreur : il n'ya pas de " + message);
	}
}
