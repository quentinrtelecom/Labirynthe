package labyrinthe;

import java.io.PrintWriter;

public class EBox extends MBox{
	public EBox(Maze maze, int line, int column) {
		super(maze, line, column);
	}
	@Override
	public boolean canPass() {
		return true;
}
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('E');
	}
	public final String getBoxSymbol()
	{
		return "E";
	}
}
