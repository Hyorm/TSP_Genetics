package tsp.main;

import java.awt.*;
import java.util.*;

public class Main{

	public static void main(String[] args){
		
		String str = "";
		
		int[][] arr = new int[48][48];

		try{

			str = (ReadFile.readFile(args[0]));
			//System.out.println(str);
			arr = Parser.setNode(str);

		}catch(Exception e){
	
			System.out.println("File Name Error");

		}
	}
}
