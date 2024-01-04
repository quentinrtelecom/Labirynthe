package maintest;
import labyrinthe.Maze;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.Reader;
import labyrinthe.MazeReadingException;

public class MainTest {

	public static void main(String[] args) throws IOException, FileNotFoundException, MazeReadingException{
		// TODO Auto-generated method stub
Maze maze = new Maze();
maze.initFromTextFile("D:\\Documents\\Télécom\\Programmation\\workspace_java\\labyrinthe\\data\\labyrinthe.txt");
maze.saveToTextFile("labyrinthe2");
System.out.println("machin");
	}

}
