package cci.tree;

public class FlattenBinaryTree {

	public static void main(String[] args) {
		FlattenBinaryTree fbt = new FlattenBinaryTree();
		TreeNodeBT root = new TreeNodeBT(1);
		root.left = new TreeNodeBT(2);
		root.right = new TreeNodeBT(5);
		root.left.left = new TreeNodeBT(3);
		root.left.right = new TreeNodeBT(4);
		
		root.right.right = new TreeNodeBT(6);
		
		fbt.inorder(root);
		
		fbt.flatten(root);
		System.out.println();
		fbt.inorder(root);
		

	}
	
	public void inorder(TreeNodeBT root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
		
	}
	
	public void flatten(TreeNodeBT root) {
        if(root == null)
            return;
		
		// lets reach the leaf node first.
        flatten(root.left);
        flatten(root.right);
        
		// Storing this so that it can be attached at to the end
        TreeNodeBT right = root.right;
		// will use this to iterate next (right in this case)
        TreeNodeBT curr = root; 
        
		// move what is left of the node to the right and remove left
        root.right = root.left;
        root.left = null;
        
		// keep going right till leaf node and attach right (stored) at the end.
        while(curr.right != null) curr = curr.right;
        curr.right = right;
    }
}


class TreeNodeBT {
	int val;
	TreeNodeBT left;
	TreeNodeBT right;

	TreeNodeBT() {
	}

	TreeNodeBT(int val) {
		this.val = val;
	}

	TreeNodeBT(int val, TreeNodeBT left, TreeNodeBT right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
 
