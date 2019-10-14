package cci.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class DFSGraph {

	private int V;
	private List<Integer> adj[];
	static int count=0;
	static int id[];

	public DFSGraph(int v) {
		V = v;
		id=new int[v];
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public void dfsTraversal(int s) {
		boolean[] visited = new boolean[V];
		dfsUtil(s, visited);
	}
// To calculate number of connected graphs here we have 2
	public void dfsTraversalUnconnected() {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfsUtil(i, visited);
				count++;
			}
		}
	}

	public void dfsUtil(int s, boolean[] visited) {
		visited[s] = true;
		id[s]=count;
		System.out.print(s + " ");
		ListIterator<Integer> i = adj[s].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				dfsUtil(n, visited);
			}
		}
	}

	public static void main(String[] args) {
		DFSGraph g = new DFSGraph(6);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(4, 5);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.dfsTraversal(2);
		System.out.println();
		g.dfsTraversalUnconnected();
		System.out.println();
		System.out.println("Count:"+count);
		System.out.println("id[2]:"+id[2]);
		System.out.println("id[4]:"+id[4]);
		

	}

}
