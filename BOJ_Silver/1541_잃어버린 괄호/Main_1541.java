package boj_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split("-");
		
		int n = 0, answer = 0;
		for(int i = 0; i < input.length; i++) {
			String[] temp = input[i].split("\\+");
			
			for(String s2 : temp) {
				n += Integer.parseInt(s2);
			}
			
			if(i == 0) {
				answer = n;
			} else {
				answer -= n;
			}
			
			n = 0;
		}
		
		System.out.println(answer);
	}
}
