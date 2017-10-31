package tsp.main;

import tsp.evolution.*;

import java.awt.*;
import java.util.*;

public class Main{

	public static void main(String[] args){
		
		String str = "";
		
		Integer[][] arr = new Integer[48][48];
	
		Set<Integer[]> sequence = new HashSet<Integer[]>();

		Path path_1 = new Path();

		try{

			str = (ReadFile.readFile(args[0]));

			arr = MakeNode.setNode(str);
			
			sequence = MakeSequence.makeSequence();
		
			for(Integer[] num: sequence){
				
				//for (int i = 0; i < 48; i++)
				//	System.out.println(num[i]+" ");

				path_1 = new Path(arr, num);
				break;				
			}

			System.out.println(path_1.getWeight());

		}catch(Exception e){
	
			System.out.println("File Name Error");

		}
	}
}
