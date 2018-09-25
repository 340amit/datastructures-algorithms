package cci.graph;

import java.util.Arrays;

public class KruskalMST {

	class Edge implements Comparable<Edge> {
		int src, des, weight;

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	class Subsets {
		int parent, rank;
	}

	int V, E;
	Edge edge[];

	public KruskalMST(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; i++) {
			edge[i] = new Edge();
		}
	}

	int find(Subsets subsets[], int i) {
		if (subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}
		return subsets[i].parent;
	}

	void union(Subsets subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {
			subsets[xroot].parent = yroot;
			subsets[xroot].rank++;
		}
	}

	void findKruskalMST() {
		Edge result[] = new Edge[V];
		int e = 0;
		int i;
		for (i = 0; i < V; i++) {
			result[i] = new Edge();
		}
		Arrays.sort(edge);
		Subsets subsets[] = new Subsets[V];
		for (i = 0; i < V; i++) {
			subsets[i] = new Subsets();
		}
		for (int v = 0; v < V; v++) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		i = 0;
		while (e < V - 1) {
			Edge next_edge = new Edge();
			next_edge = edge[i++];
			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.des);
			if (x != y) {
				result[e++] = next_edge;
				union(subsets, x, y);
			}
		}
		System.out.println("Print MST");
		for (i = 0; i < e; i++) {
			System.out.println(result[i].src + "--" + result[i].des + "==" + result[i].weight);
		}
	}

	public static void main(String[] args) {
		int V = 4;
		int E = 5;
		KruskalMST graph = new KruskalMST(V, E);
		graph.edge[0].src = 0;
		graph.edge[0].des = 1;
		graph.edge[0].weight = 10;

		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].des = 2;
		graph.edge[1].weight = 6;

		// add edge 0-3
		graph.edge[2].src = 0;
		graph.edge[2].des = 3;
		graph.edge[2].weight = 5;

		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].des = 3;
		graph.edge[3].weight = 15;

		// add edge 2-3
		graph.edge[4].src = 2;
		graph.edge[4].des = 3;
		graph.edge[4].weight = 4;

		graph.findKruskalMST();

	}

}
