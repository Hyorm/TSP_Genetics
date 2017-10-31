package tsp.main;

import java.util.*;
import java.awt.*;

public class MakeNode{

	public static Integer[][] setNode(String str){

		Integer[][] node = new Integer[48][48];

		int row = 0;

		str = str.replace("0EOF", "");

		String[] substr = str.split(" 0 ");

		node[0][0] = 0;

		for(String sub: substr){
		
			try{

				row++;

				if(row == 1)continue;

				Integer[] att = element(sub);

				for(int j = 0; j<row; j++){
	
					node[row-1][j] = att[j];
					node[j][row-1] = att[j];

				}
		
				node[row-1][row-1] = 0;

			}catch(Exception e){	

				e.printStackTrace();
	
			}
		}

		return node;

	}

	public static Integer[] element(String str) throws Exception{

		String[] sub = str.split(" ");

		Integer[] arr = new Integer[48];

		for(int i = 0; i<sub.length; i++){
			if(sub[i] == null)
				sub[i] = "0";
			
			
			//System.out.println(sub[i]+"\n");
	
			arr[i] = Integer.parseInt(sub[i]);
	
		}
		
		return arr;
	}
}
