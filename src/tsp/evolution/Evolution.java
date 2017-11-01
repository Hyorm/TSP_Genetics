package tsp.evolution;

import java.awt.*; 
import java.util.*; 

public class Evolution{


	protected Generation oldGeneration = new Generation();

	protected Generation nextGeneration = new Generation();

	protected Integer[][] node = new Integer[48][48];

	public Evolution(){}

	public Evolution(Generation generation, Integer[][] node){

		this.oldGeneration = generation;

		nextGeneration = oldGeneration;

		nextGeneration.setGeneration(new Cross_over(oldGeneration, node).getCross_over());


	}

	public Generation getEvolution(){

		return this.nextGeneration;
	
	}
}
