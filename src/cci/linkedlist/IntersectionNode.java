package cci.linkedlist;

public class IntersectionNode {
	static Node head1;
	static Node head2;

	static class Node {
		int data;
		Node next;

		public Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		IntersectionNode in = new IntersectionNode();
		head1 = new Node(1);
		head1.next = new Node(2);
		Node p = new Node(3);
		head1.next.next = p;
		head1.next.next = new Node(4);
		System.out.println(in.getIntersection(head1, head2));

	}

	Node getIntersection(Node n1, Node n2) {
		if (n1 == null || n2 == null)
			return null;
		Node c1 = n1;
		int count1 = 0;
		Node p1 = null;
		while (c1 != null) {
			count1++;
			p1 = c1;
			c1 = c1.next;
		}

		Node c2 = n2;
		int count2 = 0;
		Node p2 = null;
		while (c2 != null) {
			count2++;
			p2 = c2;
			c2 = c2.next;
		}

		if (p1 != p2)
			return null;

		Node longer = count1 > count2 ? n1 : n2;
		Node smaller = count1 > count2 ? n2 : n1;
		int diff = Math.abs(count1 - count2);

		while (diff > 0 && longer != null) {
			longer = longer.next;
			diff--;
		}
		while (smaller != longer) {
			smaller = smaller.next;
			longer = longer.next;
		}

		return smaller;
	}

}
