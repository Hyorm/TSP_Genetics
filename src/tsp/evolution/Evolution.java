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

		Integer[] oldSequence1 = new Integer[seq];
		
		Integer[] oldSequence2 = new Integer[seq];

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

		oldSequence1 = this.oldGeneration.getPath(num[0]).getSequence();

		for(int i = 0; i < seq/2; i++){

			for(int j=0; j<seq;j++){
				if(oldSequence1[j]==halfSequence[i]){

					nextSequence[j] = oldSequence1[j];
					//System.out.println(j+">"+nextSequence[j]);
				}
			}
		}

		oldSequence2 = this.oldGeneration.getPath(num[1]).getSequence();

		int old2Num=0;

		for(int i=0; i < seq; i++){

			if(nextSequence[i]==null){

					for(int j=0; j<seq; j++){
	
						if(oldSequence2[old2Num]==nextSequence[j]){
							old2Num++;
							j=-1;
						}
					}
					nextSequence[i] = oldSequence2[old2Num];
				
			}
		}
		for(int i = 0; i < seq; i++){
                        for(int j =0; j<i; j++){
                                if(nextSequence[i]==nextSequence[j])
                                        System.out.println("invalid");
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

		int changeNode = (int)(Math.random()*47)+1;

		Integer changePath = (int)(Math.random()*48);

		Integer[] changeSequence = new Integer[changeNode];

		Integer[] oldSequence = new Integer[48];

		Integer[] nextSequence = new Integer[48];

		Integer[] sequenceCH = new Integer[changeNode];

		for(int i = 0; i < changeNode ; i++){ 
 	 
  			changeSequence[i] = (int)(Math.random()*48);  
  				  
  			for(int j = 0; j < i; j++){  
   
  				if(changeSequence[i] == changeSequence[j]){  
  					i--;  
  					break;  
  				}  
			} 
 		} 
		for(int i = 0; i < changeNode ; i++){

			sequenceCH[i] = (int)(Math.random()*changeNode);

			for(int j = 0; j < i; j++){
	
				if(sequenceCH[i] == sequenceCH[j]){
					i--;
					break;
				}
			}
		}

		

		oldSequence = this.oldGeneration.getPath(changePath).getSequence();
		
		for(int i = 0; i < changeNode; i++){
				
			nextSequence[changeSequence[i]] = oldSequence[changeSequence[sequenceCH[i]]];
			
		}

		for(int i = 0; i< 48; i++){

			if(nextSequence[i]==null){
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

			i++;
		}

		return nextPath;
	}
}
