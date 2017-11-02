package tsp.evolution;

import java.util.*;
import java.awt.*;

import tsp.main.*;

public class Evolution{

	public static final int seq = 48;

	protected Generation oldGeneration = new Generation();

	protected Generation nextGeneration = new Generation();
	
	protected Integer[][] node = new Integer[seq][seq];

	public Evolution(){}

	public Evolution(Generation generation, Integer[][] node){

		this.oldGeneration = generation;

		this.node = node;

		nextGeneration = oldGeneration;

		nextGeneration.setGeneration(getCross_over());

		nextGeneration.setGeneration(getMutation());

		nextGeneration.setGeneration(getImmigration());

	}

	public Generation getEvolution(){

		return this.nextGeneration;

	}

	public Path[] getCross_over(){

		Path path[] = new Path[40];

		for(int i = 0; i<40; i++){
		
			path[i] = makeCross_over();

		}
		return path;
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

	public Path[] getMutation(){

		Path path[] = new Path[20];

		for(int i = 0; i<20 ; i++){

			path[i] = makeMutation();

		}

		return path;
	}

	public Path makeMutation(){

		Path nextPath = new Path();

		int changeNode = (int)(Math.random()*48);

		Integer changePath = (int)(Math.random()*48);

		Integer[] changeSequence = new Integer[changeNode];

		Integer[] oldSequence = new Integer[48];

		Integer[] nextSequence = new Integer[48];

		for(int i = 0; i < changeNode ; i++){ 
 	 
  			changeSequence[i] = (int)(Math.random()*48);  
  				  
  			for(int j = 0; j < i; j++){  
   
  				if(changeSequence[i] == changeSequence[j]){  
  					i--;  
  					break;  
  				}  
			}  
 		} 

		oldSequence = this.oldGeneration.getPath(changePath).getSequence();
		
		for(int i = 0; i< 48; i++){
				
			for(int j = 0; j < changeNode; j++){

				if(i == changeSequence[j])
					nextSequence[i] = changeSequence[j];
				else
					nextSequence[i] = oldSequence[i];

			}
		}
		
		nextPath = new Path(this.node, nextSequence);

		return nextPath;
	}

	public Path[] getImmigration(){

		Path[] nextPath = new Path[40];
		
		HashSet<Integer[]> sequence = new HashSet<Integer[]>();

		sequence = MakeSequence.makeSequence(40);
	
		int i = 0;	

		for(Integer[] sNum: sequence){
		
			nextPath[i] = new Path(this.node, sNum);
			System.out.println(i+"num"+nextPath[i].getWeight());	
			i++;
		}

		System.out.println("new"+nextPath[39].getWeight());

		return nextPath;
	}
}
