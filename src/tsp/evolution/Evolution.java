package tsp.evolution;

import java.util.*;
import java.awt.*;

import tsp.main.*;

public class Evolution{

	public static final int seq = 48;

	Path path[] = new Path[40];

	protected Generation oldGeneration = new Generation();

	protected Generation nextGeneration = new Generation();
	
	protected Integer[][] node = new Integer[seq][seq];

	public Evolution(){}

	public Evolution(Generation generation, Integer[][] node){

		this.oldGeneration = generation;

		this.node = node;

		nextGeneration = oldGeneration;

		nextGeneration.setGeneration(getCross_over());


	}

	public Generation getEvolution(){

		return this.nextGeneration;

	}

	public Path[] getCross_over(){

		for(int i = 0; i<40; i++){
		
			this.path[i] = makeCross_over();

		}
		return this.path;
	}

	public Path makeCross_over(){

		Integer[] halfSequence = new Integer[seq/2];

		Integer[] oldSequence = new Integer[seq];

		Integer[] nextSequence = new Integer[seq];	

		Path nextPath = new Path();

	
		Integer[] num = new Integer[2];
	
		for(int i = 0; i <2; i++){
	
			num[i] = (int)(Math.random()*(100));

			if(num[0] == num[1]) i--;

		}
			
		for(int i = 0; i < seq/2 ; i++){
	
 			halfSequence[i] = (int)(Math.random()*(seq)); 
 				 
 			for(int j = 0; j < i; j++){ 
 
 				if(halfSequence[i] == halfSequence[j]){ 
 					i--; 
 					break; 
 				} 
			} 

		} 

		oldSequence = this.oldGeneration.getPath(num[0]).getSequence();

		for(int i = 0; i < seq/2; i++){
				
			nextSequence[halfSequence[i]] = oldSequence[halfSequence[i]];

		}

		oldSequence = this.oldGeneration.getPath(num[1]).getSequence();

		for(int i = 0; i < seq; i++){

			for(int j = 0 ; j < seq ; j++){

				for(int k = 0; k < seq ; k++){

					if(nextSequence[i] == null && nextSequence[k] != oldSequence[j]){
						
						nextSequence[i] = oldSequence[j];
						break;
						
					}	
				}

				if(nextSequence[i] !=null) break;
			}
		}

		nextPath = new Path(this.node, nextSequence);
 
		return nextPath;
	}
}
