package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;


public class ResetMenuItem extends JMenuItem implements ActionListener{ // pour reset
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;
	
	public ResetMenuItem(DrawingApp drawingApp) {
		super("Reset") ;
		this.drawingApp = drawingApp ;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		
		int response = JOptionPane.showInternalOptionDialog(this, " Reset the maze?", "Reset ?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		switch(response) {
		case JOptionPane.CANCEL_OPTION :
			return ;
		case JOptionPane.OK_OPTION :
			drawingApp.getDrawingAppMaze().reset(10,10);
			break;
		case JOptionPane.NO_OPTION :
			break;
		}	
}
}
