package tp04;

public interface ASetInterface {

	public void AddSommet(VertexInterface vertex);
		/**ajoute un sommet à l'ensemble A
		 * @param vertex  un sommet
		 * */
	
	public boolean VerfVertex(VertexInterface vertex);
	/** vérifie si un sommet est déjà dans l'ensemble A ou pas
	 * @param vertex un sommet
	 * @return un booléen , true si le sommet est dans A et false sinon */
	
}
