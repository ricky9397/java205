package ex.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StringReader {

	public static void main(String[] args) {
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("String.txt"));
			
			while(true) {
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
