package amit.cci.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class DFSGraph {
	
	private int V;
	private List<Integer> adj[];
	
	public DFSGraph(int v) {
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<>();
		}
	}
	public void addEdge(int u,int v) {
		adj[u].add(v);
	}
	
	public void dfsTraversal(int s) {
		boolean[] visited=new boolean[V];
		dfsUtil(s,visited);
	}
	
	public void dfsTraversalUnconnected() {
		boolean[] visited=new boolean[V];
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				dfsUtil(i,visited);
			}
		}
	}
	
	public void dfsUtil(int s,boolean[] visited) {
		visited[s]=true;
		System.out.print(s+" ");
		ListIterator<Integer> i=adj[s].listIterator();
		while(i.hasNext()) {
			int n=i.next();
			if(!visited[n]) {
				dfsUtil(n,visited);
			}
		}
	}

	public static void main(String[] args) {
		DFSGraph g = new DFSGraph(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.dfsTraversal(2);

	}

}
