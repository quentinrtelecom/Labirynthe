package ihm;

public class Box { // la classe des Mbox qu'on va utiliser dans l'ihm
	private String label ;
	private int i ;
	private int j ;
	
	public Box(String label, int i , int j) {
		this.label = label;
		this.i = i ;
		this.j = j ;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
}
