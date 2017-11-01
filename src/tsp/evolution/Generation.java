package tsp.evolution;

import java.util.*; 
import java.awt.*; 

public class Generation{

	protected HashMap<Integer, Path> generation = new HashMap<Integer, Path>();

	protected Integer generationNum = 0;

	protected Integer allWeight = 0;

	protected Integer minWeight = 0;

	public Generation(){}

	public Generation(Path path){

		this.generation.put(generationNum, path);
		
		this.allWeight += path.getWeight();
		
		this.minWeight = path.getWeight();

		this.generationNum++;
	
	}

	public Generation(Path[] path){

		int i;

		for( i = 0; i < path.length;i++){

			this.generation.put(generationNum + i, path[i]);

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

	public void setGeneration(Path path){

		this.generation.put(generationNum, path);
		
		this.allWeight += path.getWeight();

		if(this.minWeight>path.getWeight())
			this.minWeight = path.getWeight();

		this.generationNum++;
	}

	public void setGeneration(Path[] path){

		int i;

		for( i = 0; i < path.length; i++){

			this.generation.put(generationNum +i, path[i]);

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

	public Path getPath(Integer gen){

		return this.generation.get(gen);
	}
	
	public Integer getAllWeight(){

		return this.allWeight;

	}

	public Integer getMinWeight(){

		return this.minWeight;

	}
}
