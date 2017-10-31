package tsp.evolution;

import java.util.*;
import java.awt.*;

public class Path{

	public static final int nodeNum= 48;

	protected Integer[] sequence = new Integer[nodeNum];

	protected Integer weight = 0;

	public Path(){};

	public Path(Integer[][] node, Integer[] setSequence){

		this.sequence = setSequence;

		for(int i = 0; i<nodeNum ; i++){
			
			if((i+1)>47)
				this.weight +=node[sequence[i]][sequence[0]];
			else
				this.weight += node[sequence[i]][sequence[i+1]];			

		}
	}

	public Integer getWeight(){

		return this.weight;

	}

	public Integer[] getSequence(){

		return this.sequence;

	}
}
