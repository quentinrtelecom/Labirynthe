package ihm;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import javax.swing.*;

public class DrawingApp extends JFrame implements ChangeListener {
private static final long serialVersionUID = 1L;

	
	private final WindowPanel windowPanel;
	private final DrawingMenuBar drawingMenuBar ;
	private String fileName;
	private DrawingAppMaze drawingAppMaze = new DrawingAppMaze();

	
	public DrawingApp(String fileName) throws IOException {
		super("Create your maze ! ");
		this.fileName = fileName;
		setJMenuBar(drawingMenuBar = new DrawingMenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));
		drawingAppMaze.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public String getFileName() {return this.fileName;}
	
	public DrawingAppMaze getDrawingAppMaze() {
		return drawingAppMaze;
	}
	public void setDrawingAppMaze(DrawingAppMaze drawingAppMaze) {
		this.drawingAppMaze = drawingAppMaze;
	}


	public void stateChanged(ChangeEvent evt) {
		try {
			windowPanel.notifyForUpdate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
