package tsp.main;

import java.awt.*;
import java.util.*;

public class Main{

	public static void main(String[] args){
		
		String str = "";

		try{

			str = (ReadFile.readFile(args[0]));
			System.out.println(str);

		}catch(Exception e){
	
			System.out.println("File Name Error");

		}
	}
}
