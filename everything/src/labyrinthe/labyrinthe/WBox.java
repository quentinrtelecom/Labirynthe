package labyrinthe;

import java.io.PrintWriter;

public class WBox extends MBox{
	public WBox(Maze maze, int line, int column) {
		super(maze, line, column);}
	
	@Override
	public boolean canPass() {
		return false;
		
	}
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('W');
	}
	public final String getBoxSymbol()
	{
		return "W";
	}
}
