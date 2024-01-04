package ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.*;

public class DimensionsGrid extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private int width ;
	private int height ;
	
	private final JLabel widthLabel ;
	private final JLabel heightLabel;
	
	private JFormattedTextField widthField;
	private JFormattedTextField heightField;

	private NumberFormat widthFormat;
	private NumberFormat heightFormat;
	
	private final DrawingApp drawingApp;
	
	public DimensionsGrid(DrawingApp drawingApp) {
	
		this.drawingApp = drawingApp ;
		this.width = drawingApp.getDrawingAppMaze().getWidth();
		this.height = drawingApp.getDrawingAppMaze().getHeight();
		
		setLayout(new BorderLayout());
		
		setUpFormats();
		
		this.widthLabel = new JLabel("Width : ");
		this.widthField = new JFormattedTextField(this.widthFormat);
		widthField.setValue( width);
		widthField.setColumns(10);
		this.widthLabel.setLabelFor(this.widthField);
		this.widthField.addPropertyChangeListener("value",this);

		this.heightLabel = new JLabel("Height : ");
		this.heightField = new JFormattedTextField(this.heightFormat);
		heightField.setValue( height);
		heightField.setColumns(10);
		this.heightLabel.setLabelFor(this.heightField);
		this.heightField.addPropertyChangeListener("value",this);

		JPanel labelPane = new JPanel(new GridLayout(0,1));
		labelPane.add(widthLabel);
		labelPane.add(heightLabel);
		
		JPanel fieldPane = new JPanel(new GridLayout(0,1));
		fieldPane.add(widthField);
		fieldPane.add(heightField);
		
		add(labelPane, BorderLayout.CENTER);
		add(fieldPane, BorderLayout.LINE_END);
	}

	
    
    public void propertyChange(PropertyChangeEvent e) {
    	DrawingAppMaze drawingAppMaze = this.drawingApp.getDrawingAppMaze();
        int nwidth = (int) ((Number) widthField.getValue()).doubleValue();
    	int nheight = (int) ((Number) heightField.getValue()).doubleValue();
        drawingAppMaze.reset(nwidth,nheight);
    }
    
    
	private void setUpFormats() {
		// TODO Auto-generated method stub
	}

	public void notifyForUpdate() {
		// TODO Auto-generated method stub
	}

}
