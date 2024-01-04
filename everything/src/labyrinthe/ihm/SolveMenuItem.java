package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JMenuItem;
import labyrinthe.MazeReadingException;
import labyrinthe.DepartureArrivalException;
import java.awt.*;
import javax.swing.*;

public class SolveMenuItem extends JMenuItem implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;
	
	public SolveMenuItem(DrawingApp drawingApp) {
		super("Solve") ;
		this.drawingApp = drawingApp ;
		addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent evt) {
		try {
			drawingApp.getDrawingAppMaze().solve();
		} catch ( MazeReadingException | IOException | DepartureArrivalException e) {
			e.printStackTrace();
		}
		
	}
}
