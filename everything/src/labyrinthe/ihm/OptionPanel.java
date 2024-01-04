package ihm;

import java.awt.GridLayout;

import java.awt.*;
import javax.swing.*;

public class OptionPanel extends JPanel { // les boutons
	private static final long serialVersionUID = 1L;
	private final DimensionsPanel dimensionsPanel ;
	private final SelectedBox selectedBox ;
	private final TypeBoxButton eTypeButton ;
	private final TypeBoxButton wTypeButton ;
	private final TypeBoxButton aTypeButton ;
	private final TypeBoxButton dTypeButton ;
	
	public OptionPanel(DrawingApp drawingApp) { 
		setLayout(new GridLayout(1,6));
		
		add(dimensionsPanel = new DimensionsPanel(drawingApp));
		add(selectedBox = new SelectedBox(drawingApp));
		add(eTypeButton = new TypeBoxButton(drawingApp,"Empty"));
		add(wTypeButton = new TypeBoxButton(drawingApp,"Wall"));
		add(aTypeButton = new TypeBoxButton(drawingApp,"Arrival"));
		add(dTypeButton = new TypeBoxButton(drawingApp,"Departure"));
		
		
	}

	public void notifyForUpdate() {
		dimensionsPanel.notifyForUpdate();
		selectedBox.notifyForUpdate();
		
	}
}
