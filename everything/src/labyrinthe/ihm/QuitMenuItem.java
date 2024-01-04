package ihm;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class QuitMenuItem extends JMenuItem implements ActionListener{ //pour quitter
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;
	
	public QuitMenuItem(DrawingApp drawingApp) {
		super("Quit") ;
		this.drawingApp = drawingApp ;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		DrawingAppMaze drawingAppMaze = drawingApp.getDrawingAppMaze();
		
		int response = JOptionPane.showInternalOptionDialog(this, "Maze not saved. Export it?", "Quit Application", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		switch(response) {
		case JOptionPane.CANCEL_OPTION :
			return ;
		case JOptionPane.OK_OPTION :
			try {
				drawingAppMaze.export();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case JOptionPane.NO_OPTION :
			break;
		}
		System.exit(0);
	
	}
}
