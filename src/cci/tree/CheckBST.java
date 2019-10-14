package cci.tree;

public class CheckBST {
	Node root;

	public static void main(String[] args) {
		/*4
	2		5
1		3	*/
		
		CheckBST tree = new CheckBST(); 
        tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3);
        
        /*tree.root = new Node(4); 
        tree.root.left = new Node(4);*/ 
        
        /*tree.root = new Node(4); 
        tree.root.right = new Node(4);*/ 
        
        System.out.println(tree.isBST());

	}
	
	boolean isBST() {
		return isBST(root,null,null);
	}
	boolean isBST(Node root,Integer min,Integer max) {
		if(root==null) return true;
		
		if(!isBST(root.left,min,root.data) || !isBST(root.right,root.data,max) )
			return false;
		
		if((min !=null && min>=root.data) ||(max !=null && max < root.data))
			return false;
		
		return true;
	}

}
