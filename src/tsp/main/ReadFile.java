package tsp.main;

import java.awt.*;
import java.util.ArrayList;
import java.io.*;

public class ReadFile{
	
	public static String readFile(final String fileName) throws IOException{
			
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		String line;

		int i = 0;

		while((line = br.readLine()) != null){	
		
			if(i>=7)	
				sb.append(line);
			i++;

		}
		
		return sb.toString();

	}

}
