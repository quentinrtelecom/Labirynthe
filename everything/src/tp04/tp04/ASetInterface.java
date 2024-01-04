package tp04;

public interface ASetInterface {

	public void AddSommet(VertexInterface vertex);
		/**ajoute un sommet � l'ensemble A
		 * @param vertex  un sommet
		 * */
	
	public boolean VerfVertex(VertexInterface vertex);
	/** v�rifie si un sommet est d�j� dans l'ensemble A ou pas
	 * @param vertex un sommet
	 * @return un bool�en , true si le sommet est dans A et false sinon */
	
}
