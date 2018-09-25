package cci.linkedlist;

import java.util.HashSet;

public class RemoveDuplicates {
	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		rd.head = new Node(1);
		rd.head.next = new Node(2);
		rd.head.next.next = new Node(1);
		rd.head.next.next.next = new Node(3);
		rd.printList();
		rd.kthFromLast(3);
		// rd.removeDuplicates();
		// rd.printList();

	}

	// Remove duplicates elements
	public void removeDuplicates() {
		Node temp = head, prev = null;
		HashSet<Integer> hs = new HashSet<>();
		while (temp != null) {
			if (hs.contains(temp.data)) {
				prev.next = temp.next;
			} else {
				hs.add(temp.data);
				prev = temp;
			}
			temp = temp.next;
		}
	}

	// Find kth element from last
	public void kthFromLast(int k) {
		Node temp = head;
		Node pointer = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
			if (count > k) {
				pointer = pointer.next;
			}
		}
		if (temp == null) {
			System.out.println(pointer.data);
		}
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
