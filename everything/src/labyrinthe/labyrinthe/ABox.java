package labyrinthe;
import java.io.PrintWriter;

import labyrinthe.Maze;
public class ABox extends MBox {
	public ABox(Maze maze, int line, int column) {
		super(maze, line, column);}
	
	@Override
	public boolean canPass() {
		return true; }
	
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('A');
	}
	public final String getBoxSymbol()
	{
		return "A";
	}
}
