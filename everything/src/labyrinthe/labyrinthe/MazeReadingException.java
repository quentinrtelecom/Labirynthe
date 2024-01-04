package labyrinthe;

public class MazeReadingException extends Exception{

	public final static long serialVersionUID = 1L ;

	public MazeReadingException (String fileName, int lineNo, String errorMsg)
	{
		super("Erreur d�tect�e pendant la lecture du labyrinthe dans " + fileName + "(" + lineNo + ")" + errorMsg);
	}
}
