package tp04;
import java.util.ArrayList;
public interface GraphInterface {

	public ArrayList<VertexInterface> getListVertex();
	/** renvoie la liste des sommets du graphe */
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);
	/** renvoie la liste des successeurs d'un sommet du graphe*/
	
	public int getWeight(VertexInterface src,VertexInterface scc);
	/** @param src un sommet
	 * @param scc un successeur du sommet précédent
	 * @return le poids de l'arête (src,scc)
	 */
}
