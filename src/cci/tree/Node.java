package cci.tree;

class Node {
	public Node left;
	public Node right;
	public int data;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}
