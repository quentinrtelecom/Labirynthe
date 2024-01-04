package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JPanel;
import java.util.ArrayList;

public class BoxesPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ArrayList<ArrayList<BoxPanel>> boxesPanel ;
	private DrawingApp drawingApp; 
	private GridLayout gridLayout;
	BoxPanelMouseListener	boxesPanelMouseListener = new BoxPanelMouseListener(drawingApp);
	
	public BoxesPanel(DrawingApp drawingApp) throws IOException {
		this.drawingApp = drawingApp ;
		addMouseListener(boxesPanelMouseListener);
		DrawingAppMaze drawingAppMaze = drawingApp.getDrawingAppMaze();
		int width = drawingAppMaze.getWidth();
		int height = drawingAppMaze.getHeight();
		this.gridLayout = new GridLayout(height,width,1,1);
		setLayout(gridLayout);

		ArrayList<ArrayList<BoxPanel>> boxesPanel = new ArrayList<ArrayList<BoxPanel>>();
		ArrayList<ArrayList<Box>> boxesModel = drawingAppMaze.getBoxes();
		for (int k = 0; k<height; k++) {
			ArrayList<BoxPanel> truc = new ArrayList<BoxPanel>();
			for (int l = 0; l<width; l++) {
				truc.add(new BoxPanel(drawingApp, new Box("W",k,l)));
			}
			boxesPanel.add(truc);
		}
		for(ArrayList<Box> rows : boxesModel) {
			for(Box box : rows) {
				int i = box.getI();
				int j = box.getJ();
				BoxPanel boxPanel = new BoxPanel(drawingApp,box);
				boxesPanel.get(i).set(j, boxPanel);
				add(boxPanel);
			}
		}
		setBackground(Color.WHITE);
		
	}

	public ArrayList<ArrayList<BoxPanel>> getBoxesPanel() {
		return boxesPanel;
	}

	public void setBoxesPanel(ArrayList<ArrayList<BoxPanel>> boxesPanel) {
		this.boxesPanel = boxesPanel;

	}
	
    private void fillGrid() throws IOException {
        this.removeAll();
		DrawingAppMaze drawingAppMaze = drawingApp.getDrawingAppMaze();
		ArrayList<ArrayList<Box>> boxesModel = drawingAppMaze.getBoxes();
        for (int row = 0; row < gridLayout.getRows(); row++) {
            for (int col = 0; col < gridLayout.getColumns(); col++) {
               BoxPanel boxPanel = new BoxPanel(drawingApp,boxesModel.get(row).get(col)) ; 
               this.add(boxPanel);
            }
        }
        revalidate();
        repaint();
    }

	public void notifyForUpdate() throws IOException {
		
		DrawingAppMaze drawingAppMaze = drawingApp.getDrawingAppMaze();
		if(drawingAppMaze.isModified()) {
			int width = drawingAppMaze.getWidth();
			int height = drawingAppMaze.getHeight();	
			gridLayout.setColumns(width);
			gridLayout.setRows(height);
			fillGrid();
		}
	}
}
