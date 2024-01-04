package ihm;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

public class WindowPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final BoxesPanel boxesPanel ;
	private final OptionPanel optionPanel;
	
	public WindowPanel(DrawingApp drawingApp) throws IOException {
	
		setLayout(new BorderLayout());
		
		add(boxesPanel = new BoxesPanel(drawingApp), BorderLayout.CENTER);
		add(optionPanel = new OptionPanel(drawingApp), BorderLayout.SOUTH);

	}

	public void notifyForUpdate() throws IOException {
		boxesPanel.notifyForUpdate();
		optionPanel.notifyForUpdate();

	}
}
