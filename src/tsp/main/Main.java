package tsp.main;

import tsp.evolution.*;

import java.awt.*;
import java.util.*;

public class Main{

	public static void main(String[] args){
		
		String str = "";
		
		Integer[][] arr = new Integer[48][48];
	
		HashSet<Integer[]> sequence = new HashSet<Integer[]>();

		Generation generation = new Generation();

		Generation nextGeneration = new Generation();

		Path[] path = new Path[100];

		try{

			str = (ReadFile.readFile(args[0]));

			arr = MakeNode.setNode(str);
			
			sequence = MakeSequence.makeSequence(100);
		
			int i = 0;

			for(Integer[] num: sequence){

				path[i] = new Path(arr, num);
				i++;
			}
						
			generation.setGeneration(path);

			System.out.println(generation.getAllWeight()/100);

			nextGeneration = new Evolution(generation, arr).getEvolution();

			System.out.println(nextGeneration.getPath(170).getWeight());

		}catch(Exception e){
	
			System.out.println("File Name Error");
		}
	}
}
