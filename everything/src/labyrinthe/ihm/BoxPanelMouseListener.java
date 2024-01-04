package ihm;

import java.awt.event.*;

public class BoxPanelMouseListener extends MouseAdapter implements MouseListener {
DrawingApp drawingApp ;
	
	public BoxPanelMouseListener(DrawingApp drawingApp) {
		super();
		this.drawingApp = drawingApp ;
	}
	
	@Override
	public final void mouseReleased(MouseEvent e) {
		DrawingAppMaze drawingAppModel = drawingApp.getDrawingAppMaze();
		String selectedBox = drawingAppModel.getSelectedBox();
		BoxPanel boxPanel = (BoxPanel) e.getSource();
		int i = boxPanel.getBox().getI() ;
		int j = boxPanel.getBox().getJ() ;
		if(selectedBox == "Arrival") {
			drawingAppModel.setBox(i,j,"A");
		} else if(selectedBox == "Wall") {
			drawingAppModel.setBox(i,j, "W");
		} else if(selectedBox == "Departure") {
			drawingAppModel.setBox(i,j, "D");
		} else if(selectedBox == "Empty") {
			drawingAppModel.setBox(i,j, "E");
		}
	}
}
