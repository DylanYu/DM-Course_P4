package wekaUsing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Process {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Double> list1 = new ArrayList<Double>();
		FileInputStream filein = new FileInputStream("output.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(filein));
		String line = br.readLine();
		int i = 0;
		int count_1 = 0;
		int count_all = 0;
		while(line != null) {
			String[] strs = line.split(",");
			double d1 = Double.valueOf(strs[1]);
			list1.add(d1);
			count_all++;
			if(d1 > 0.9)
				count_1++;
			System.out.println(i++ + "::" + strs[0] + "," + strs[1]);
			line = br.readLine();
		}
		
		System.out.println(String.format("%d/%d", count_1, count_all));
		
//		Collections.sort(list1, Collections.reverseOrder());
//		FileOutputStream out = new FileOutputStream("ordered1_output.txt");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
//		for(int l_count = 0; l_count < list1.size(); l_count++) {
//			bw.write(String.valueOf(list1.get(l_count)));
//			//bw.write("\r\n");
//			bw.newLine();
//		}
//		bw.close();
	}

}
