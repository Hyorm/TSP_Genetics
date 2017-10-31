package tsp.main;

import java.awt.*;
import java.util.*;

public class MakeSequence{

	public static final int seqNum = 48;
	
	public static Set<Integer[]> makeSequence(){

		Set<Integer[]> sequence = new HashSet<Integer[]>();

		for(int i = 0;i<100; i++){
	
			try{

				sequence.add(randElement(seqNum));					

			}catch(Exception e){

				e.printStackTrace();

			}
		}

		return sequence;
	}

	public static Integer[] randElement(int num) throws Exception{

		Integer[] randNum = new Integer[num];
	
		for(int i = 0; i < num; i++){

			randNum[i] = (int)(Math.random()*(num));
			
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
