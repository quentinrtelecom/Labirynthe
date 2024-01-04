package tp04;

import java.util.ArrayList;

/* @author quentin raynaud */
public final class Dijkstra {
	
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		return dijkstra(g, r, new ASet(), new Pi(), new Previous());
	}
	
	
	private static PreviousInterface dijkstra(GraphInterface g, VertexInterface r,ASetInterface a, PiInterface pi, PreviousInterface previous) {
	
		a.AddSommet(r);
		VertexInterface pivot = r;
		
		pi.setValue(r, 0);
		ArrayList<VertexInterface> liste_sommets = g.getListVertex();
		
		ArrayList<VertexInterface> verticesNotInA = new ArrayList<VertexInterface>(g.getListVertex());
		verticesNotInA.remove(r);
		
		
	
		int n = liste_sommets.size();
		for (VertexInterface vertex : liste_sommets) {
			if (vertex!=r)
				pi.setValue(vertex, Integer.MAX_VALUE);
			
		}
		
		
		for (int j=1; j<n; j++) {
			
			
			ArrayList<VertexInterface> successpivot = g.getSuccessors(pivot);
			
		
			for (VertexInterface y : successpivot) {
				if(!a.VerfVertex(y)) {
					if(pi.getValue(pivot) + g.getWeight(pivot, y) < pi.getValue(y)) {
						pi.setValue(y,pi.getValue(pivot) + g.getWeight(pivot,y));
						previous.setPrevious(y, pivot);
				
								
					}
					
				}
			
	
}
			pivot=pi.minimalDistance(verticesNotInA);
			a.AddSommet(pivot);
			verticesNotInA.remove(pivot);
							
						}

			
		
	
			
			

		return previous;
	}
}
