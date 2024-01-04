package ihm;

import java.awt.*;
import javax.swing.*;

public class MazeMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private final SolveMenuItem solveMenuItem;
	private final ResetMenuItem resetMenuItem;
	
	public MazeMenu(DrawingApp drawingApp) {
		super("Maze");
		add(solveMenuItem = new SolveMenuItem(drawingApp));
		add(resetMenuItem = new ResetMenuItem(drawingApp));
		
	}
}
