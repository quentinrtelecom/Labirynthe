package ihm;


import java.awt.*;
import javax.swing.*;


public class SelectedBox extends JPanel {
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;
	private String selectedBox ;
	
	public SelectedBox(DrawingApp drawingApp) {
		
		this.drawingApp = drawingApp ;
		this.selectedBox = drawingApp.getDrawingAppMaze().getSelectedBox();

	}

	@Override
	protected final void paintComponent(Graphics g)
	{
		DrawingAppMaze drawingAppMaze= drawingApp.getDrawingAppMaze();
	   // peint l'arrière-plan
		super.paintComponent(g) ;
			
	   
	   int w = getWidth() ;
	   int h = getHeight() ;
	  
	   this.selectedBox = drawingAppMaze.getSelectedBox();

	   int length = selectedBox.length();
	   char[] data = new char[length];
	   for(int i=0 ; i<length ; i++) {
		   data[i] = selectedBox.charAt(i);
	   }
	   g.drawChars(data, 0, data.length, w/3, h/2);
	   // dessine une bordure

	}
	
	public void notifyForUpdate() {
		DrawingAppMaze drawingAppMaze = drawingApp.getDrawingAppMaze();
		if(drawingAppMaze.isModified()) {
			this.selectedBox = drawingAppMaze.getSelectedBox();
			repaint();
		}
	}
}
