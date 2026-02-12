package boj_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019 {

	static int A,B;
	static int d = 4;
	static String[] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 0; t < T; t++) {
			arr = new String[10000];
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			System.out.println(algo()); 
		}
		
	}

	
	static String algo() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[10000];
		
		q.add(A);
		visited[A] = true;
		arr[A] = "";
		
		while(!q.isEmpty()) {
			int cur = q.poll();			
			
			if(cur == B) return arr[cur];
			String op = "";
			for(int i = 0; i < d; i++) {
				int DSLR = cur;
				if(i == 0) {
					DSLR = cur * 2 % 10000;
					op = "D";
				}
				
				else if(i == 1) {
					DSLR = cur - 1;
					if(DSLR < 0) DSLR = 9999;
					op = "S";
				}
				
				else if(i == 2) {
					int n = cur / 1000;
					DSLR = (DSLR - n * 1000) * 10 + n;
					op = "L";
				}
				
				else if(i == 3) {
					int n = cur % 10;
					DSLR = (DSLR - n) / 10 + (n * 1000);
					op = "R";
				}
				
				if(visited[DSLR]) continue;
				q.add(DSLR);
				arr[DSLR] = arr[cur] + op;
				visited[DSLR] = true;
			}
		}
		return null;
	}
}
