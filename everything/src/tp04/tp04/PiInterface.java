package tp04;

import java.util.ArrayList;

public interface PiInterface {

	public void setValue(VertexInterface vertex, int value);
	/**permet d'assigner à un sommet vertex la valeur de pi(vertex)*/
	
	public int getValue(VertexInterface vertex);
	/** @param vertex un sommet
	 * @return la valeur de pi(vertex)
	 */
	public VertexInterface minimalDistance(ArrayList<VertexInterface> vertexList);
}
