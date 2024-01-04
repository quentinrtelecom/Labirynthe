package labyrinthe;

import java.io.PrintWriter;

import labyrinthe.Maze;

public class SBox extends MBox{
	public SBox(Maze maze, int line, int column)
	{
		super(maze, line, column);
	}

	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('*');
	}

	public final String getBoxSymbol()
	{
		return "*";
	}
}
