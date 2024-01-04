package maintest;

import java.io.FileNotFoundException;

import tp04.*;
import labyrinthe.*;
import java.io.IOException;
import ihm.*;

/*
@author quentin raynaud
*/

public class MainClass {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		DrawingApp res = new DrawingApp("data/labyrinthe.txt");
		try {
			res.getDrawingAppMaze().export();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

