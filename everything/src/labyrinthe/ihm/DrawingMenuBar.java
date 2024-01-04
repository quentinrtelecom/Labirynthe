package ihm;

import javax.swing.JMenuBar;
import java.awt.*;
import javax.swing.*;

public class DrawingMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private final FileMenu fileMenu ;
	private final MazeMenu mazeMenu ;
	
	public DrawingMenuBar(DrawingApp drawingApp) {
		super();
		add(fileMenu = new FileMenu(drawingApp));
		add(mazeMenu = new MazeMenu(drawingApp));
	}
}
