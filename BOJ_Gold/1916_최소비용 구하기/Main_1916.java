package boj_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {
	
	static class Edge {
		int B, cost;
		
		Edge(int B, int cost) {
			this.B = B;
			this.cost = cost;
		}
	}
	
	static class State implements Comparable<State> {
		int node;
		int cost;
		
		public State(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}



		@Override
		public int compareTo(State s) {
			return Integer.compare(this.cost, s.cost);
		}
		
	}
	
	static int N, M, start, end;
	static List<Edge>[] graph;
	static int INF = Integer.MAX_VALUE / 4;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[A].add(new Edge(B, cost));
		}
		
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		System.out.println(algo());
	}
	
	static int algo() {
		PriorityQueue<State> queue = new PriorityQueue<State>();
		int[] city = new int[N+1];
		
		Arrays.fill(city, INF);
		city[start] = 0;
		
		queue.add(new State(start, 0));
		
		while(!queue.isEmpty()) {
			State cur = queue.poll();
			
			if(cur.cost != city[cur.node]) continue;
			if(cur.node == end) return cur.cost;
			
			for(Edge edge : graph[cur.node]) {
				int curCost = city[cur.node] + edge.cost;
				if(city[edge.B] > curCost) {
					city[edge.B] = curCost;
					queue.add(new State(edge.B, curCost));
				}
			}
		}
		
		return city[end];
	}
	
}
