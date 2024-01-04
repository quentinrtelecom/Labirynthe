package labyrinthe;

import java.io.PrintWriter;

public class DBox extends MBox {
	public DBox(Maze maze, int line, int column) {
		super(maze, line, column);}
	@Override
	public boolean canPass() {
		return false; }
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('D');
	}
	
	public final String getBoxSymbol()
	{
		return "D";
	}
}
