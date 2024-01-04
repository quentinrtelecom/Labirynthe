package tp04;

import java.util.ArrayList;

public interface PreviousInterface {

	public void setPrevious(VertexInterface vertex, VertexInterface previous); 
	/** @param vertex le sommet fils
	 * 
	 * @param previous le sommet p�re
	 */

	public VertexInterface getPrevious(VertexInterface vertex);
	/** renvoie le p�re d'un sommet

	 */

	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);
	
}
