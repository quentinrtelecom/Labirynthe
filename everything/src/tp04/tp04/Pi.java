package tp04;
import java.util.ArrayList;
import java.util.Hashtable;
public class Pi extends Hashtable<VertexInterface, Integer> implements PiInterface{
	public static final long serialVersionUID = 1L;
	
	private static Hashtable<VertexInterface, Integer> pi;
	
	public Pi() {
		pi = new Hashtable<VertexInterface, Integer>();
	}
	
	public void setValue(VertexInterface vertex, int value) {
		pi.put(vertex, value);
	}
	
	public int getValue(VertexInterface vertex) {
		return pi.get(vertex);
	}
	public VertexInterface minimalDistance(ArrayList<VertexInterface> vertexList) {
		int minDist = Integer.MAX_VALUE;
		int distanceV = 0;
		VertexInterface minV = vertexList.get(0);
		for (VertexInterface v: vertexList){
			distanceV = pi.get(v);
			if (distanceV < minDist) {
				minV=v;
				minDist = distanceV;				
			}
		}
		return minV;
	}
}
