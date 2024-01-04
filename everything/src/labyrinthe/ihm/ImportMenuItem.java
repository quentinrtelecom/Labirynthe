package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import labyrinthe.MazeReadingException;
import javax.swing.JMenuItem;

import java.awt.*;
import javax.swing.*;

public class ImportMenuItem extends JMenuItem implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;
	
	public ImportMenuItem(DrawingApp drawingApp) {
		super("Import") ;
		this.drawingApp = drawingApp ;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)  {
		DrawingAppMaze drawingAppMaze = drawingApp.getDrawingAppMaze();
		
		/*Faire une pop up qui affiche un label "Indiquer le chemin du lab à importer
		sous le format : data/<mylab.txt>"
		Un champ de texte
		Et un bouton import qui ferme le pop up et affiche le lab importé 
		*/
		try {
			String fileToImport = drawingApp.getFileName();
			drawingAppMaze.importFromText(fileToImport);
		} catch (IOException | MazeReadingException e) {
			e.printStackTrace();
		}
	}
}
