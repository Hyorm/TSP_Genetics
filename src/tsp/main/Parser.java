package tsp.main;

import java.util.*;
import java.awt.*;

public class Parser{
	
	public static int[][] setNode(String str){

		int[][] array = new int[48][48];
		
		int row = 0;
		
		String[] substr = str.split(" 0 ");

		for(String sub : substr){

			try{

				int[] att = attributes(sub);

				for(int j = 0; j<att.length; j++){

					array[row][j] = att[j];

				}
				array[row][row] = 0;
				}
			
				row++;
			
			}catch(Exception e){

				e.printStackTrace();

			}
		}

		for (int i = 0; i < array.length; i++) {
			 System.out.println();
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
		      }
		}
		
		return array;

	}

	public static int[] attributes(String str) throws Exception{

		String[] sub = str.split(" ");

		int[] arr = new int[48];

		for(int i = 0; i<sub.length; i++)
			arr[i] = Integer.parseInt(sub[i]);
		
	
		return arr;
		
	}
}
