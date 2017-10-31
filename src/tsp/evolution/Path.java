package tsp.evolution;

import java.util.*;
import java.awt.*;

public static final int nodeNum= 48;

public class Path{

	protected int[] sequence = new int[nodeNum];

	protected Integer weight = 0;

	public Path(Integer[][] node, int[] setSequence){

		this.sequence = setSequence;

		for(int i = 0; i<nodeNum ; i++){
			
			if((i+1)>47)
				this.weight +=node[sequence[i]][sequence[0]]
			else
				this.weight += node[sequence[i]][seqence[i+1]]			

		}
	}

	public Integer getWeight(){

		return this.weight;

	}

	public int[] getSequence(){

		return this.sequence;

	}
}
