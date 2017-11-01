package tsp.main;

import tsp.evolution.*;

import java.awt.*;
import java.util.*;

public class Main{

	public static void main(String[] args){
		
		String str = "";
		
		Integer[][] arr = new Integer[48][48];
	
		Set<Integer[]> sequence = new HashSet<Integer[]>();

		Generation generation = new Generation();

		Path[] path = new Path[100];

		try{

			str = (ReadFile.readFile(args[0]));

			arr = MakeNode.setNode(str);
			
			sequence = MakeSequence.makeSequence();
		
			int i = 0;

			for(Integer[] num: sequence){
				
				path[i] = new Path(arr, num);

				i++;
			}

			generation.setGeneration(path);

			System.out.println(generation.getMinWeight());

		}catch(Exception e){
	
			System.out.println("File Name Error");

		}
	}
}
