package cci.linkedlist;

public class LinkedListReverse {

	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int d) {
			data = d;
			next = null;
		}
	}

	public Node reverse(Node node) {
		Node current = node;
		Node prev = null;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public void display(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedListReverse list = new LinkedListReverse();
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);

		list.display(head);
		head = list.reverse(head);
		list.display(head);

	}

}
