package graph;

import java.util.ArrayList;

public class GraphMain {

	public static void main(String[] args) {

		Graph graph = new Graph();

		int V = 5;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}

		graph.addEdge(adj, 0, 1);
		graph.addEdge(adj, 0, 4);
		graph.addEdge(adj, 1, 2);
		graph.addEdge(adj, 1, 3);
		graph.addEdge(adj, 1, 4);
		graph.addEdge(adj, 2, 3);
		graph.addEdge(adj, 3, 4);

		graph.printGraph(adj);

		Graph graph2 = new Graph(5);
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 4);
		graph2.addEdge(1, 2);
		graph2.addEdge(1, 3);
		graph2.addEdge(1, 4);
		graph2.addEdge(2, 3);
		graph2.addEdge(3, 4);
		
		System.out.println("########################");
		System.out.println("New graph");
		graph2.printGraph(adj);

		System.out.println("BFS ");
		graph2.BFS(0);
		System.out.println();
		System.out.println("DFS ");
	    graph2.DFS (0);

	}

}
