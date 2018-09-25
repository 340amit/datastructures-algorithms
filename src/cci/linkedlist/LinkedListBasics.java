package cci.linkedlist;

public class LinkedListBasics {
	Node head;

	public static void main(String[] args) {
		/* Start with the empty list */
		LinkedListBasics llist = new LinkedListBasics();

		// Insert 6. So linked list becomes 6->NUllist
		llist.append(6);

		// Insert 7 at the beginning. So linked list becomes
		// 7->6->NUllist
		llist.push(7);

		// Insert 1 at the beginning. So linked list becomes
		// 1->7->6->NUllist
		llist.push(1);

		// Insert 4 at the end. So linked list becomes
		// 1->7->6->4->NUllist
		llist.append(4);

		// Insert 8, after 7. So linked list becomes
		// 1->7->8->6->4->NUllist
		llist.insertAfter(llist.head.next, 8);

		System.out.println("\nCreated Linked list is: ");
		llist.printList();

		llist.delete(6);
		System.out.println();
		llist.printList();
		System.out.println();
		System.out.println(llist.getCount());
		llist.deleteNode(2);
		llist.printList();

	}

	static class Node {
		int data;
		Node next;

		public Node(int d) {
			data = d;
			next = null;
		}
	}

	// Insert at first
	public void push(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

	// Insert After
	public void insertAfter(Node prev_node, int data) {
		if (prev_node == null) {
			System.out.println("Cannot be null");
		}
		Node new_node = new Node(data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}

	// Insert at end
	public void append(int data) {
		Node new_node = new Node(data);
		if (head == null) {
			head = new_node;
			return;
		}
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = new_node;
		return;
	}

	// delete node
	public void delete(int key) {
		Node temp = head, prev = null;
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}

		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;

		prev.next = temp.next;
	}

	public int getCountRec(Node node) {
		if (node == null)
			return 0;
		return 1 + getCountRec(node.next);
	}

	public int getCount() {
		return getCountRec(head);
	}

	// Delete Node by position
	public void deleteNode(int pos) {
		if (head == null)
			return;
		Node temp = head;
		if (pos == 0) {
			head = temp.next;
			return;
		}
		for (int i = 0; i < pos - 1 && temp != null; i++) {
			temp = temp.next;
		}
		if (temp == null || temp.next == null)
			return;
		// Node next=temp.next.next;
		// temp.next=next;
		temp.next = temp.next.next;
	}

	void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

}
