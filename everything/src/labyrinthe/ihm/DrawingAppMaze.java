package ihm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tp04.Dijkstra;
import tp04.PreviousInterface;
import tp04.VertexInterface;
import labyrinthe.DepartureArrivalException;
import labyrinthe.MBox;
import labyrinthe.Maze;
import labyrinthe.MazeReadingException;


public class DrawingAppMaze { 
	private int width = 10 ;
	private int height = 10;
	private String selectedBox = "Wall";
	private ArrayList<ArrayList<Box>> boxes ;
	private boolean modified = false ;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	
	public DrawingAppMaze() {
		boxes =new ArrayList<ArrayList<Box>>();
		for(int i = 0 ; i<height ; i++) {
			ArrayList<Box> arrayI = new ArrayList<Box>();
			for(int j = 0 ; j< width ; j++) {
				arrayI.add(new Box("W", i , j));
			}
			boxes.add(arrayI);
		}
	}
	
	public void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for(ChangeListener listener : listeners) {
			listener.stateChanged(evt);
		}
	}
			
		
	
	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}
	public int getWidth() {return width;}
	public void setWidth(int width) {
		if(this.width != width) {
			this.width = width ;
			modified = true ; 
			stateChanges();
		}
	}
	public int getHeight() {return height;}
	public void setHeight(int height) {
		if (this.height != height) {
			this.height = height ;
			modified = true ; 
			stateChanges();
		}
	}
	public String getSelectedBox() {return selectedBox;}
	
	public void setSelectedBox(String selectedBox) {
		if(this.selectedBox != selectedBox) {
			this.selectedBox = selectedBox;
			modified = true ; 
			stateChanges();
		}
	}
	public ArrayList<ArrayList<Box>> getBoxes() {return boxes;}
	public void setBoxes(ArrayList<ArrayList<Box>> boxes) {
		this.boxes = boxes;
		modified = true ; 
		stateChanges();
	}

	public void setBox(int i, int j, String type) {
		Box box = new Box(type,i,j);
		this.boxes.get(i).set(j,box);
		modified = true ;
		stateChanges();
	}
	
	public boolean isModified() {
		return modified;
	}
	
	
	public void export() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream("data/export.txt"));
		for(ArrayList<Box> row : boxes) {
			for(Box box : row) {
				pw.print(box.getLabel());
			}
			pw.println();
		}
		pw.close();
	}

	public void reset(int nwidth,int nheight) {
		this.width = nwidth ;
		this.height = nheight ; 
		this.selectedBox = "W" ;
		ArrayList<ArrayList<Box>> rBoxes =new ArrayList<ArrayList<Box>>();
		for(int i = 0 ; i<nheight ; i++) {
			ArrayList<Box> provArray = new ArrayList<Box>();
			for(int j = 0 ; j< nwidth ; j++) {
				provArray.add(new Box("W", i , j));
			}
			rBoxes.add(provArray);
		}
		this.setBoxes(rBoxes);
	}
	
	public void solve() throws FileNotFoundException, MazeReadingException, DepartureArrivalException, IOException{
		export();
		Maze m = new Maze();
		m.initFromTextFile("data/export.txt");	
		MBox departure = (MBox) m.getDeparture();
		MBox arrival = (MBox) m.getArrival ();
				
		PreviousInterface previous =  Dijkstra.dijkstra( m , departure);
		ArrayList<VertexInterface> path = previous.getShortestPathTo(arrival);
		m.showPath(m, path);
		this.importFromText("data/solution.txt");
		}
	
	public void importFromText(String fileName) throws FileNotFoundException, MazeReadingException, IOException {
		Maze m = new Maze();
		m.initFromTextFile(fileName);
		ArrayList<ArrayList<MBox>> cases = m.getCases() ;
		int width = cases.get(0).size();
		int height = cases.size();
		ArrayList<ArrayList<Box>> nboxes = new ArrayList<ArrayList<Box>>();
		for(int i = 0 ; i<height ; i++) {
			ArrayList<Box> provList = new ArrayList<Box>();
			for(int j = 0 ; j<width ; j++) {
				String label = cases.get(i).get(j).getBoxSymbol();
				provList.add(new Box(label, i, j));
			}
			nboxes.add(provList);
		}
		this.width = width ;
		this.height = height ;
		this.setBoxes(nboxes);
	}
}
