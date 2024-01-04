package labyrinthe;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


import labyrinthe.DepartureArrivalException;
import labyrinthe.MazeReadingException;

import labyrinthe.MBox;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.Reader;

import tp04.*;

public class Maze implements GraphInterface{ // la classe du labyrinthe
	private ArrayList<ArrayList<MBox>> cases;
	private int n; //hauteur
	private int m; // largeur
	private VertexInterface departure;
	private VertexInterface arrival;
	private boolean isSolved = false;
	
	public ArrayList<ArrayList<MBox>> getCases() {
		return cases;
	}
	public ArrayList<VertexInterface> getListVertex() {
		ArrayList<VertexInterface> listVertex = new ArrayList<VertexInterface>();
		
		for( int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				listVertex.add(cases.get(i).get(j));
			}
		}
		return listVertex;
	}
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		ArrayList<VertexInterface> successeurs = new ArrayList<VertexInterface>();
		MBox box = (MBox)vertex;
		int c = box.getColumn();
		int l = box.getLine();
		if (l > 0) // Voisins du dessus
		{ 
			MBox neighbor = cases.get(l-1).get(c);
			
			if (neighbor.canPass())
				successeurs.add(neighbor);
		}

		if (l < n-1) // Voisins du dessous
		{ 
			MBox neighbor = cases.get(l+1).get(c);
			if (neighbor.canPass())
				successeurs.add(neighbor);
		}

		if (c > 0) // Voisins de gauche
		{ 
			MBox neighbor = cases.get(l).get(c-1);
			if (neighbor.canPass())
				successeurs.add(neighbor);
		}

		if (c < m-1) // Voisins de droite
		{ 
			MBox neighbor = (cases.get(l)).get(c+1);
			if (neighbor.canPass())
				successeurs.add(neighbor);
		}	
		return successeurs;
		
	}
	public int getWeight(VertexInterface src, VertexInterface dst) {
		return 1;
	}
	
	
	public final void initFromTextFile(String fileName) throws FileNotFoundException, MazeReadingException, IOException{
		
		FileReader reader = new FileReader(fileName);
		
		BufferedReader br = new BufferedReader(reader);
		ArrayList<Integer> dimensions = count(fileName);
		int height = dimensions.get(1);
		int width = dimensions.get(0);
		this.n = height ;
		this.m = width;
		this.cases = new ArrayList<ArrayList<MBox>>();
		try {
			
			
			for (int lineNo = 0; lineNo < height ; lineNo++ ) 
			{
			
			String line = br.readLine();
			
			if (line == null)
				throw new MazeReadingException(fileName, lineNo, ": pas assez de ligne");
			if (line.length() < m-2)
				throw new MazeReadingException(fileName, lineNo, ": la ligne est trop courte");
			if (line.length() > m)
				throw new MazeReadingException(fileName, lineNo, ": la ligne est trop longue");
	
			ArrayList<MBox> prov = new ArrayList<MBox>();
		for (int colNo = 0; colNo < width ; colNo++)
			{
			
			switch(line.charAt(colNo))
				{
			case 'A' :
			prov.add(new ABox(this,lineNo, colNo));
			
			break;
			
			case 'D' :
				prov.add(new DBox(this,lineNo, colNo));
				
				break;
				
			case 'W' :
				prov.add(new WBox(this,lineNo, colNo));
				
				break;
				
			case 'E' :
				prov.add(new EBox(this,lineNo, colNo));
				
				break;
			case '.' :
				prov.add(new SBox(this,lineNo, colNo));
				
				break;
			default :
				throw new MazeReadingException(fileName, lineNo, ": caract√®re inconnu '");
			
				}
			}
		cases.add(prov);
		}
		}
		finally {
			if (reader != null)
			{	
				try {
					reader.close(); 
				} catch (Exception e) {};
			}

			if (br != null)
			{
				try {
					br.close(); 
				} catch (Exception e) {};		
			}
			}
	}
public final void saveToTextFile(String fileName) throws FileNotFoundException
{
	PrintWriter pwMaze = new PrintWriter(fileName);

	try {			
		
		for (int lineNo = 0 ; lineNo < n-2 ; lineNo++)			
		{
			
			ArrayList<MBox> line = cases.get(lineNo) ;
			for (int colNo = 0 ; colNo < m-2 ; colNo++)
			{			    	 
				line.get(colNo).writeCharTo(pwMaze);
			} 
			pwMaze.println();			        
		}
		
		

	} finally {

		if (pwMaze != null)
		{
			try {pwMaze.close(); 
			
			} catch (Exception e) {};		
		}		
	}
}
public final MBox getBox(int line, int column) // renvoie la case aux coordonnÈes en argument
{
	return cases.get(line).get(column);
}

private final void setBox(int line, int column, char symbol) // pour crÈer un labyrinthe
	{switch (symbol) 
	{
	case 'D' :
	cases.get(line).set(column, new DBox(this, line, column)); break;
	case 'A' :
		cases.get(line).set(column, new ABox(this, line, column)); break;
	case 'W' :
		cases.get(line).set(column, new WBox(this, line, column)); break;
	case 'E' :
		cases.get(line).set(column, new EBox(this, line, column)); break; 			
	default :
		return;
	}
}
private final ArrayList<Integer> count(String fileName) throws MazeReadingException{

	ArrayList<Integer> res = new ArrayList<Integer>();
	try {
		BufferedReader file =new BufferedReader(new FileReader(fileName));
		String strCurrentLine = file.readLine();
		
		if ( strCurrentLine == null) { 
			file.close() ;
			throw new MazeReadingException ( fileName,0 , " : Fichier vide");}
		
		int width = strCurrentLine.length();
		int height = 1 ;
		@SuppressWarnings("unused")
		String data;
		while((data = file.readLine()) != null) {
			height++;                  
		}
		res.add(width);
		res.add(height);
		file.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch( IOException e) {
		e.printStackTrace();
	}
	return res;
}
public final VertexInterface getDeparture() throws DepartureArrivalException { //renvoie la case de dÈpart
	for (int i=0 ; i<n ; i++) {
		for (int j = 0 ; j<m ; j++) {
			VertexInterface box = this.cases.get(i).get(j) ;
			if (box.getBoxSymbol() == "D") {
				
				return box ; }
		}
	}
	throw new DepartureArrivalException(" dÈpart");
}


 
public final VertexInterface getArrival() throws DepartureArrivalException { // renvoie la case d'arrivÈe
	for (int i=0 ; i<n ; i++) {
		for (int j = 0 ; j<m ; j++) {
			VertexInterface box = this.cases.get(i).get(j) ;
			if (box.getBoxSymbol() == "A") {
				return box ; }
		}
	}
	throw new DepartureArrivalException("arrivÈe");
}

public String getSymbolForBox(int row, int column) // renvoie le symbole de la box
{		
	try {
		String symbol = cases.get(row).get(column).getBoxSymbol();
		return symbol;

	} catch (ArrayIndexOutOfBoundsException e) {
		System.err.println("Erreur: Vous ne pouvez pas √©diter cette case");
		Component frame = null;
		JOptionPane.showMessageDialog(frame, "Vous ne pouvez pas √©diter cette case !", "Attention !", JOptionPane.WARNING_MESSAGE);
		return null;

	} catch (NullPointerException e) {	
		System.err.println("Erreur: Vous ne pouvez pas √©diter cette case");
		Component frame = null;
		JOptionPane.showMessageDialog(frame, "Vous ne pouvez pas √©diter cette case !", "Attention !", JOptionPane.WARNING_MESSAGE);
		return null;			
	}
}	


public void setSymbolForBox(int row, int column, String symbol) // permet de changer le type de case
{   
	if (row==0 || column==0 || row==n-1 || column==m-1)
	{
		System.err.println("Erreur: Vous ne pouvez pas √©diter cette case");
		Component frame = null;
		JOptionPane.showMessageDialog(frame, "Vous ne pouvez pas √©diter cette case !", "Attention !", JOptionPane.WARNING_MESSAGE);
		return;
	}     

	else if (isSolved)
	{
		ask(departure, arrival);
		return;
	}

	else
	{    	
		try{
			switch (symbol)     	
			{
			case "D" :
			cases.get(row).add(new DBox(this,row,column)); break;
			case "A" :
				cases.get(row).add(new ABox(this,row,column)); break;
			case "W" :
				cases.get(row).add(new WBox(this,row,column)); break;
			case "E" :
				cases.get(row).add(new EBox(this,row,column)); break;  
			case "*" :
				cases.get(row).add(new EBox(this,row,column)); break;        		
			default :  
				return;
			}

		}  catch (IndexOutOfBoundsException e) {    	              
			System.out.println("Vous ne pouvez pas √©diter cette case");
			Component frame = null;
			JOptionPane.showMessageDialog(frame, "Vous ne pouvez pas √©diter cette case !", "Information", JOptionPane.WARNING_MESSAGE);	

		} catch (NullPointerException e) {
			System.out.println("Vous ne pouvez pas √©diter cette case");
			Component frame = null;
			JOptionPane.showMessageDialog(frame, "Vous ne pouvez pas √©diter cette case !", "Information", JOptionPane.WARNING_MESSAGE);				   				
		}
	}
}     


public boolean isValid() // permet de dÈterminer si le labyrinthe a bien 1 seul dÈpart et 1 seule arrivÈe
{
	int a=0;
	int d=0;
	for (int i=0 ; i < n ; i++)
	{
		for (int j=0 ; j < m ; j++)
		{
			if (this.getSymbolForBox(i,j).equals("D"))
			{
				d=d+1;
			}

			if (this.getSymbolForBox(i,j).equals("A"))
			{
				a=a+1;
			}
		}
	}

	if (!(a==1 && d==1))
	{
		return false;
	}
	else
	{
		return true;
	}
}

public void calculateShortestPath() throws NullPointerException // calcule le plus court chemin entre la case de dÈpart et la case d'arrivÈe
{		
	try {   	    
		if (isSolved)
		{
			ask(departure, arrival);
		}

		if (isValid())
		{     	   	   	
			for (int i=0 ; i < n ; i++)
			{
				for (int j=0 ; j < m ; j++)    				
				{
					if (getSymbolForBox(i,j).equals("D"))
					{
						departure = getBox(i,j);
					}

					if (getSymbolForBox(i,j).equals("A"))
					{
						arrival = getBox(i,j);    						
					}
				}
			}         	

			Previous p = (Previous) Dijkstra.dijkstra(this, departure);      	    	
			ArrayList<VertexInterface> shortestPath = p.getShortestPathTo(arrival);

			if (!(isSolvable(shortestPath)))
			{
				System.err.println("Erreur: Le labyrinthe n'est pas solvable");
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Le labyrinthe n'est pas solvable !", "Erreur", JOptionPane.ERROR_MESSAGE); 
				return;
			}

			else 
			{
				printShortestPath(shortestPath); 
				isSolved=true;
				ask(departure, arrival);					
				return;
			} 
		}

		else
		{
			System.err.println("Erreur: Le labyrinthe n'est pas valide");
			Component frame = null;
			JOptionPane.showMessageDialog(frame, "Le labyrinthe n'est pas valide !", "Erreur", JOptionPane.ERROR_MESSAGE); 
			return;
		} 

	} catch(NullPointerException e){
		System.err.println("Erreur: Aucun labyrinthe n'est charg√©");
		Component frame = null;
		JOptionPane.showMessageDialog(frame, "Aucun labyrinthe n'est charg√© !", "Erreur", JOptionPane.ERROR_MESSAGE);  

	} finally {
		Window[] windows = Window.getWindows();
		for(int i=0 ; i < windows.length ; i++)
		{
			windows[i].repaint();				
		}
	}
}  

public void showPath(Maze g, ArrayList<VertexInterface> path) throws DepartureArrivalException, FileNotFoundException {
	
	for (VertexInterface vertex : path) {
		System.out.println(vertex.getBoxSymbol());
	}
	
	if( !path.contains(g.getDeparture())) {
		System.out.print("Erreur : le labyrinthe n'a pas de solution");
		//return ;
	}
	
	PrintWriter pw = new PrintWriter(new FileOutputStream("data/solution.txt"));
	
	MBox departure =(MBox) g.getDeparture() ;
	MBox arrival =(MBox) g.getArrival() ;
	for( int i = 0 ; i< g.n ; i++) {
		for( int j = 0 ; j <g.m ; j++) {
			MBox box = g.cases.get(i).get(j) ;
			if( path.contains(box) && (box != departure) && (box != arrival)) {
				pw.print(".");
				System.out.print(".");
			}
			else{
				pw.print(g.cases.get(i).get(j).getBoxSymbol());
				System.out.print(g.cases.get(i).get(j).getBoxSymbol());
				}
			}
		pw.println("");
		System.out.println("");
		}
	pw.close();
	}


private void printShortestPath(ArrayList<VertexInterface> shortestPath)  
{
	int x=0;
	int y=0;		
	Iterator<VertexInterface> it = shortestPath.iterator();
	if(shortestPath != null)
	{
		while(it.hasNext())
		{
			MBox box = (MBox)it.next();
			x = box.getLine();
			y = box.getColumn();
			setSymbolForBox(x, y, "*"); 
		}			
	}
}

private boolean isSolvable(ArrayList<VertexInterface> shortestPath)
{
	if (shortestPath.size()<2)
	{
		return false; 
	}

	else
	{
		return true;
	}
}   

private void ask(VertexInterface d, VertexInterface a)
{				
	int option = JOptionPane.showConfirmDialog(null, "Le labyrinthe est r√©solu ! Voulez-vous effacer le chemin de r√©solution ? ", "Bravo !", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);					
	if(option == JOptionPane.OK_OPTION)
	{
		for (int i=1 ; i < n-1 ; i++)
		{
			for (int j=1 ; j < m-1 ; j++)
			{					
				if(getSymbolForBox(i,j)=="*")
				{
					setBox(i, j, 'E');
				}
			}
		}	

		setBox(((MBox) d).getLine(), ((MBox) d).getColumn(), 'D');
		setBox(((MBox) a).getLine(), ((MBox) a).getColumn(), 'A');		
		isSolved=false;
	}
}	
}
