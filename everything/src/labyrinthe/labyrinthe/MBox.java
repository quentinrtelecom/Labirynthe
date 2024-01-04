package labyrinthe;
import java.io.PrintWriter;
import labyrinthe.Maze;
import tp04.VertexInterface;
public abstract class MBox implements VertexInterface {
	private final int line;
	private final int column;
	private Maze maze;
	
	public MBox(Maze maze, int line, int column) {
		this.line = line;
		this.column = column;
		this.maze = maze;
	}
	public int getLine() {
		return line;
	}
	public int getColumn() {
		return column;
	}
	public abstract String getBoxSymbol();
	
	public String getLabel() {
		return "(" + line + " , "+ column + ")";
		
	}
	public boolean canPass() {
		return true;
	}
	public void writeCharTo(PrintWriter pw)
	{
		
	}
	
}
