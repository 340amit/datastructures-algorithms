package amit.cci.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	
	Node root;
	
	public TreeNode() {
		root=null;
	}
	
	void insert(int val) {
		root=insertR(root,val);
	}
	Node insertR(Node root,int val) {
		if(root==null) {
			root=new Node(val);
			return root;
		}	
		if(val<root.data)
			root.left=insertR(root.left,val);
		else
			root.right=insertR(root.right,val);
		return root;
	}
	void printInorder() {
		printInorder(root);
	}
	void printInorder(Node root) {
		if(root==null) return;
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
	}
	
	void printPreorder() {
		printPreorder(root);
	}
	void printPreorder(Node root) {
		if(root==null) return;
		System.out.print(root.data+" ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	void printPostorder() {
		printPostorder(root);
	}
	void printPostorder(Node root) {
		if(root==null) return;
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data+" ");
	}
	
	void printLevelorder() {
		printLevelorder(root);
	}
	
	void printLevelorder(Node root) {
		if(root==null) return;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null) q.add(temp.left);
			if(temp.right!=null) q.add(temp.right);
		}
	}
	
	Node search(int key) {
		return search(root,key);
	}
	Node search(Node root,int key) {
		if(root==null || root.data==key) return root;
		if(key<root.data) {
			return search(root.left,key);
		}
		return search(root.right,key);
		
	}
	
	public static void main(String[] args) {
		
		TreeNode tn=new TreeNode();
		/* Let us create following BST
        50
     /     \
    30      70
   /  \    /  \
 20   40  60   80 */
		tn.insert(50);
		tn.insert(30);
		tn.insert(40);
		tn.insert(20);
		tn.insert(70);
		tn.insert(60);
		tn.insert(80);
		
		tn.printInorder();
		System.out.println();
		tn.printPreorder();
		System.out.println();
		tn.printPostorder();
		System.out.println();
		tn.printLevelorder();
		System.out.println();
		Node sKey=tn.search(40);
		System.out.println();
		System.out.println("sKey:"+(sKey!=null?sKey.data:"false"));
		
	}

}
