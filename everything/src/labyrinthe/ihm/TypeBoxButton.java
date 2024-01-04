package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



public class TypeBoxButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;

	public TypeBoxButton(DrawingApp drawingApp, String type) {
		super(type);
		this.drawingApp = drawingApp;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		DrawingAppMaze drawingAppMaze = drawingApp.getDrawingAppMaze();
		String label = this.getText();
		drawingAppMaze.setSelectedBox(label);
	}
}
