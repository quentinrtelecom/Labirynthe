package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.*;
import javax.swing.*;

public class ExportMenuItem extends JMenuItem implements ActionListener{ //pour exporter
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;
	
	public ExportMenuItem(DrawingApp drawingApp) {
		super("Export") ;
		this.drawingApp = drawingApp ;		
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		DrawingAppMaze drawingAppModel = drawingApp.getDrawingAppMaze();
		
		int response = JOptionPane.showInternalOptionDialog(this, " Export the maze?", "Export ?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		switch(response) {
		case JOptionPane.CANCEL_OPTION :
			return ;
		case JOptionPane.OK_OPTION :
			try {
				drawingAppModel.export();
				System.out.println("Maze exported as 'export.txt'");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case JOptionPane.NO_OPTION :
			break;
		}	
	}	
}
