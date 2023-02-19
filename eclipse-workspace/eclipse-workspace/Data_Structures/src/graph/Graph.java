package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private int V;
	private LinkedList<Integer> adj[];
	private Queue<Integer> queue;

	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
		queue = new LinkedList<Integer>();
	}

	Graph() {

	}

	void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void BFS(int n) {
		boolean nodes[] = new boolean[V];
		int a = 0;
		
		nodes[n] = true;
		queue.add(n);
		
		while(queue.size() != 0) {
			n = queue.poll();
			System.out.print(n + " ");
			for(int i=0; i < adj[n].size(); i++) {
				a = adj[n].get(i);
				if(!nodes[a]) {
					nodes[a] = true;
					queue.add(a);
				}
			}
		}
		
		
	}
	
	void DFS(int n) {
		boolean[] already = new boolean[V];
		DFSUtil(n, already);
	}

	private void DFSUtil(int vertex, boolean[] nodes) {
		nodes[vertex] = true;
		System.out.print(vertex + " ");
		
		int a = 0;
		
		for(int i=0; i<adj[vertex].size(); i++) {
			a = adj[vertex].get(i);
			if(!nodes[a]) {
				DFSUtil(a, nodes);
			}
		}
		
	}

	void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.println("Adjeceny list of vertex " + i);
			System.out.print("Head");

			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

}
