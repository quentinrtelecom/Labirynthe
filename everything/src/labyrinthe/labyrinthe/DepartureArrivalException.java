package labyrinthe;

public class DepartureArrivalException extends Exception {

	private static final long serialVersionUID = 1L;

	
	/** Lève une exception si le labyrinthe ne possède pas d'arrivée ou de départ
	 * 
	 */
	public DepartureArrivalException(String message) {
		super("Erreur : il n'ya pas de " + message);
	}
}
