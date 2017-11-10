package tsp.main;

import tsp.evolution.*;
import tsp.gui.*;

import java.awt.*;
import java.util.*;

class MultiThread extends Thread{

	long now;
	Integer[][] node = new Integer[48][48];

	public MultiThread(long now, Integer[][] arr){

		this.now = now;
		this.node = arr;

	}

	public void run(){

		Path minPath = new Path();
		Path newPath = new Path();

		HashSet<Integer[]> se = new HashSet<Integer[]>();		

		int generath = 0;

		while(true){

			long endTime = System.currentTimeMillis();

			if((endTime - now)/1000==30) break;

			se = MakeSequence.makeSequence(1);
			
			for(Integer[] num: se)
				newPath = new Path(node, num);

			if(generath==0)
				minPath = newPath;
			if(newPath.getWeight()<minPath.getWeight())
				minPath = newPath;

			generath++;
		}
		System.out.println(generath+" Randome Generation Min Weight: "+ minPath.getWeight());
	}
}

public class Main{
	public static void main(String[] args){
		
		String str = "";

		long startTime = System.currentTimeMillis();
		
		Integer[][] arr = new Integer[48][48];
	
		HashSet<Integer[]> sequence = new HashSet<Integer[]>();

		Generation[] allGeneration = new Generation[2];

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

			int j = 1, gen = 0, generationNum = 0;

			MultiThread rand_1 = new MultiThread(startTime, arr);

			rand_1.start();
			while(true){
					
				long endTime = System.currentTimeMillis();

				if((endTime - startTime)/1000==30) break;
				
				if(j == 1){
					allGeneration[j] = new Evolution(allGeneration[j-1], arr).getEvolution();
				
					gen = j;
					j--;
				}
				else {
					allGeneration[j] = new Evolution(allGeneration[j+1], arr).getEvolution();
					gen = j;
					j++;
				}
				
				generationNum++;

				System.out.println(generationNum+" Generation Min Weight: "+ allGeneration[gen].getMinWeight());

			}
	
				
//			ShowData dataHist= new ShowData(allGeneration);
			
//			dataHist.showMinWeight();
			
//			dataHist.showAllWeight();				


		}catch(Exception e){
	
			System.out.println("File Name Error");
		}
	}
}
