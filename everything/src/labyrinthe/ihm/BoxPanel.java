package ihm;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;



public class BoxPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Box box;
	BoxPanelMouseListener boxesPanelMouseListener;
	
	private static Image wall ;
	private static Image empty ;
	private static Image path;
	private static Image arrivee ;
	private static Image depart ;
	
	static { 
		try {
			
			wall =ImageIO.read(new File("data/mur.jpg"));
			empty = ImageIO.read(new File("data/chemin.jpg"));
			path = ImageIO.read(new File("data/giroud.png"));
			arrivee = ImageIO.read(new File("data/arrivee.jpg"));
			depart = ImageIO.read(new File("data/depart.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	public BoxPanel(DrawingApp drawingApp,Box box) throws IOException {
		boxesPanelMouseListener = new BoxPanelMouseListener(drawingApp);
		this.box = box;
		addMouseListener(boxesPanelMouseListener);
	}

	public Box getBox() {return box;}
	
	 @Override
	public void paintComponent(Graphics g) {
	   // Paint the background
	   super.paintComponent(g) ;

	   if(box.getLabel() =="A") {
		    g.drawImage(arrivee, 0,0,getWidth(),getHeight(),this);
	    }else if( box.getLabel() == "D") {
		    g.drawImage(depart, 0,0,getWidth(),getHeight(),this);
		}else if (box.getLabel() == "E") {
			g.drawImage(empty, 0,0,getWidth(),getHeight(),this);
		}else if (box.getLabel() == "W") {
			g.drawImage(wall, 0,0,getWidth(),getHeight(),this);
		}else {
			g.drawImage(path, 0,0,getWidth(),getHeight(),this);
		}
}
}
