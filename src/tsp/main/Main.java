package tsp.main;

import tsp.evolution.*;
import tsp.gui.*;

import java.awt.*;
import java.util.*;

public class Main{

	public static void main(String[] args){
		
		String str = "";
		
		Integer[][] arr = new Integer[48][48];
	
		HashSet<Integer[]> sequence = new HashSet<Integer[]>();

		Generation[] allGeneration = new Generation[100];

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
						
			allGeneration[0] = new Generation(path);
			
			for(int j =1; j<100; j++){
			
				 allGeneration[j] = new Evolution(allGeneration[j-1], arr).getEvolution();
			}
	
			ShowData dataHist= new ShowData(allGeneration);
			
			dataHist.showMinWeight();
			
			dataHist.showAllWeight();				


		}catch(Exception e){
	
			System.out.println("File Name Error");
		}
	}
}
