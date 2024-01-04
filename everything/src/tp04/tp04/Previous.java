package tp04;
import java.util.ArrayList;
import java.util.Hashtable;

public class Previous extends Hashtable<VertexInterface, VertexInterface> implements PreviousInterface{
	public static final long serialVersionUID = 1L;
	private static Hashtable<VertexInterface, VertexInterface> prev;
	
	public Previous() {
		prev = new Hashtable<VertexInterface, VertexInterface>();
	}
	public void setPrevious(VertexInterface vertex, VertexInterface previous)
	{
		prev.put(vertex, previous);
	}
	public VertexInterface getPrevious(VertexInterface vertex)
	{
		return prev.get(vertex);
	}
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex)
	{
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>();
		while (vertex != null) {
			path.add(vertex);
			vertex = getPrevious(vertex);
		}
		return path;
	}
}
