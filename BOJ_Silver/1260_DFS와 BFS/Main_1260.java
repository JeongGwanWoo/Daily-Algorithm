package boj_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.DelayQueue;

public class Main_1260 {
	// https://www.acmicpc.net/status?from_problem=1&problem_id=1260
	static List<List<Integer>> arr;
	static int N, M, V;
	static List<Integer> result_bfs, result_dfs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<List<Integer>>();

		for(int i = 0; i <= N; i++) {
			arr.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		for(int i = 0; i <= N; i++) {
			Collections.sort(arr.get(i));
		}
		
		boolean[] visited = new boolean[N+1];
		result_bfs = new ArrayList<Integer>();
		result_dfs = new ArrayList<Integer>();
		BFS();
		DFS(V, visited);
		printMethod(result_dfs);
		printMethod(result_bfs);
	}
	
	static List<Integer> BFS() {
		int start = V;
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N+1];
		
		q.add(start);
		
		while(!q.isEmpty()) {
			int a = q.poll();
			
			if(visited[a]) continue;
			result_bfs.add(a);
			
			visited[a] = true;
			for(int temp : arr.get(a)) {
				q.add(temp);
			}
		}
		
		return result_bfs;
	}
	
	static void DFS(int current, boolean[] visited) {
//		Collections.sort(arr.get(current));
		visited[current] = true;
		result_dfs.add(current);
		for(int temp : arr.get(current)) {
			if(visited[temp]) continue;
			DFS(temp, visited);
		}
	}

	static void printMethod(List<Integer> result) {
		StringBuilder sb = new StringBuilder();
		for(int a : result) {
			sb.append(a + " ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
