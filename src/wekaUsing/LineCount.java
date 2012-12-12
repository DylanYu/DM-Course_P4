package wekaUsing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineCount {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream filein = new FileInputStream("D:\\Study\\DataMining\\Project_4\\smetxt\\SME_Customer_Profile.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(filein));
		String line = br.readLine();
		int count = 0;
		while (line != null) {
			count++;
			line = br.readLine();
		}
		System.out.println(count);
	}
}
