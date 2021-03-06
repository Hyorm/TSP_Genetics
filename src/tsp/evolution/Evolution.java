package tsp.evolution;

import java.util.*;
import java.awt.*;

import tsp.main.*;

public class Evolution{

	public static final int seq = 48;

	public static final int co = 40;
	public static final int mu = 10;
	public static final int im = 50;

	protected Generation oldGeneration = new Generation();

	protected Generation nextGeneration = new Generation();
	
	protected Generation selectGeneration = new Generation();

	protected Integer[][] node = new Integer[seq][seq];

	public Evolution(){}

	public Evolution(Generation generation, Integer[][] node){

		this.oldGeneration = generation;

		this.node = node;

		nextGeneration = oldGeneration;

		nextGeneration.setGeneration(getCross_over());

		nextGeneration.setGeneration(getMutation());

		nextGeneration.setGeneration(getImmigration());

		selectGeneration.setGeneration(getSelect());

	}

	public Generation getEvolution(){

		return this.selectGeneration;

	}

	public Path[] getCross_over(){

		Path path[] = new Path[co];

		for(int i = 0; i<co; i++){
		
			path[i] = makeCross_over();
			if(path[i].getWeight()>this.oldGeneration.getMinWeight())
				i--;

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

		Path path[] = new Path[mu];
		for(int i = 0; i<mu ; i++){

			path[i] = makeMutation();

		}

		return path;
	}

	public Path makeMutation(){

		Path nextPath = new Path();

		int changeNode = (int)(Math.random()*47)+1;

		Integer changePath = (int)(Math.random()*100);

		if(changePath<10)
			changeNode = (int)(Math.random()*9)+1;

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

		Path[] nextPath = new Path[im];
		
		HashSet<Integer[]> sequence = new HashSet<Integer[]>();

		sequence = MakeSequence.makeSequence(im);
	
		int i = 0;	

		for(Integer[] sNum: sequence){
		
			nextPath[i] = new Path(this.node, sNum);

			i++;
		}

		return nextPath;
	}

	public Path[] getSelect(){

		Path[] oldGen = new Path[200];
		Path[] newGen = new Path[100];
		Path[] sortedGen = new Path[200];
		Integer[] randGenNum = new Integer[50];
		for(int i =0; i<200;i++){
			oldGen[i] = this.nextGeneration.getPath(i);
		}

		sortedGen = selSort(oldGen);

		randGenNum = randG(50);

		for(int i=0; i<100; i++){

			if(i<50)
				newGen[i] = sortedGen[i];
			else
				newGen[i] = oldGen[randGenNum[i-50]];
		}	

		return newGen;
	}
	
	public Path[] selSort(Path[] path){

		Integer indexMin;
		Path tmp = new Path();
		
		for(int i = 0; i < path.length-1; i++){

			indexMin = i;
			        for (int j = i + 1; j < path.length; j++) {
					if (path[j].getWeight() < path[indexMin].getWeight()) {
						indexMin = j;
				}			
			}
 			tmp = path[indexMin];
			path[indexMin] = path[i];
			path[i] = tmp;
		}

		return path;
	}

	public Integer[] randG(int n){

		Integer[] randNum = new Integer[n]; 
 	 
 		for(int i = 0; i < n; i++){ 
 
 			randNum[i] = (int)(Math.random()*200); 
 			 
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
