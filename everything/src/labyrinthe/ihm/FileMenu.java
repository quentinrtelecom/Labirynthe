package ihm;

import javax.swing.JMenu;
import java.awt.*;
import javax.swing.*;

public class FileMenu extends JMenu{
	private static final long serialVersionUID = 1L;
	private final QuitMenuItem quitMenuItem ;
	private final ImportMenuItem importMenuItem;
	private final ExportMenuItem exportMenuItem;
	
	public FileMenu(DrawingApp drawingApp) {
		super("File") ;
		add(quitMenuItem = new QuitMenuItem(drawingApp));
		add(importMenuItem = new ImportMenuItem(drawingApp));
		add(exportMenuItem = new ExportMenuItem(drawingApp));

	}
}
