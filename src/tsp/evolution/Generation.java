package tsp.evolution;

import java.util.*; 
import java.awt.*; 

public class Generation{

	protected HashMap<Integer, Path> generation = new HashMap();

	protected Integer generationNum = 0;

	protected Integer allWeight = 0;

	protected Integer minWeight = 0;

	public Generation(){}

	public Generation(Path path){

		this.generation.put(generationNum, path);

		this.allWeight += path.getWeight();

		if(this.minWeight == 0)
			this.minWeight = path.getWeight();
		else{

			if(this.minWeight>path.getWeight())
				this.minWeight = path.getWeight();
		}

		this.generationNum++;
	}

	public Generation(Path[] path){

		int i;

		for( i = 0; i < path.length; i++){

			this.generation.put(generationNum, path[i]);
			
			this.allWeight += path[i].getWeight();

			if(this.minWeight == 0)
				this.minWeight = path[i].getWeight();
			else{
			
				if(this.minWeight>path[i].getWeight())
					this.minWeight = path[i].getWeight();
			}
		}

		this.generationNum += i;
	}

	public HashMap<Integer, Path> getGeneration(int gen){

		return this.generation;
	}
	
	public Integer getAllWeight(){

		return this.allWeight;

	}

	public Integer getMinWeight(){

		return this.minWeight;

	}
}
