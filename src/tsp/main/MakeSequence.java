package tsp.main;

import java.awt.*;
import java.util.*;

public class MakeSequence{

	public static final int seqNum = 48;
	
	public static HashSet<Integer[]> makeSequence(){

		HashSet<Integer[]> sequence = new HashSet<Integer[]>();

		for(int i = 0;i<100; i++){
	
			boolean y;

			try{

				y = sequence.add(randElement(seqNum));
				if(y == false)
					i--;					

			}catch(Exception e){

				e.printStackTrace();

			}
		}

		return sequence;
	}

	public static Integer[] randElement(int num_r) throws Exception{

		Integer[] randNum = new Integer[num_r];
	
		for(int i = 0; i < num_r; i++){

			randNum[i] = (int)(Math.random()*(num_r));
			
			for(int j = 0; j < i; j++){

				if(randNum[i] == randNum[j]){
					i--;
					break;
				}
			}
		}

		return randNum;
	}	
}
