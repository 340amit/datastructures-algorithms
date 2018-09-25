package cci.graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class BFSGraph {

	private int V;
	private LinkedList<Integer> adj[];

	public BFSGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void bfsTraversal(int s) {
		boolean visited[] = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);
		while (!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s + " ");
			ListIterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}

	public static void main(String[] args) {
		BFSGraph g = new BFSGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.bfsTraversal(2);

	}

}
