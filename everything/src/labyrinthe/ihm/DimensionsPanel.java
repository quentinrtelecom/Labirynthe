package ihm;


import java.awt.*;
import javax.swing.*;


public class DimensionsPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private final DimensionsGrid dimensionsGrid;
	
	public DimensionsPanel(DrawingApp drawingApp) {
		setLayout(new BorderLayout());
		add(dimensionsGrid = new DimensionsGrid(drawingApp), BorderLayout.CENTER);
	}

	public void notifyForUpdate() {
		dimensionsGrid.notifyForUpdate();
	}
}
