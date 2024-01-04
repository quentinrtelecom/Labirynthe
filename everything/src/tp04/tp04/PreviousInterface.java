package tp04;

import java.util.ArrayList;

public interface PreviousInterface {

	public void setPrevious(VertexInterface vertex, VertexInterface previous); 
	/** @param vertex le sommet fils
	 * 
	 * @param previous le sommet père
	 */

	public VertexInterface getPrevious(VertexInterface vertex);
	/** renvoie le père d'un sommet

	 */

	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);
	
}
