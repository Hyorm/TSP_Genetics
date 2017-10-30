package tsp.main;

import java.awt.*;
import java.util.*;

public class Main{

	public static void main(String[] args){
		
		String str = "";
		
		Integer[][] arr = new Integer[48][48];

		try{

			str = (ReadFile.readFile(args[0]));

			arr = MakeNode.setNode(str);

			MakeNode.printNode(arr);

		}catch(Exception e){
	
			System.out.println("File Name Error");

		}
	}
}
