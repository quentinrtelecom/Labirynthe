package tp04;
import java.util.HashSet;

public class ASet extends HashSet<VertexInterface> implements ASetInterface{
	public static final  long serialVersionUID = 1L;
	
	private final HashSet<VertexInterface> aSet;
	
	public ASet() {
		aSet = new HashSet<VertexInterface>();
		
	}
	
	public void AddSommet(VertexInterface vertex)
	{
		aSet.add(vertex);
		
	}
	
	public boolean VerfVertex(VertexInterface vertex) {
		
		return aSet.contains(vertex);
		
	}
}
