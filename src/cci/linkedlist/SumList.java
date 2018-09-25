package amit.cci.linkedlist;


public class SumList {
	static Node head;

	public static void main(String[] args) {
		SumList sl = new SumList();
		Node head1 = new Node(6);
		head1.next = new Node(1);
		head1.next.next = new Node(7);

		Node head2 = new Node(2);
		head2.next = new Node(9);
		head2.next.next = new Node(5);

		sl.printList(head1);
		sl.printList(sl.reverse(head1));
		sl.printList(head2);
		sl.sumList(head1, head2);
		sl.printList(head);

	}
//	1 -> 2 -> 3 ->null
//	3 -> 2 -> 1 ->null
	Node reverse(Node n1) {
		Node prev=null;
		Node current=n1;
		Node next=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		n1=prev;
		return n1;
	}
	void sumListReverse(Node n1,Node n2) {
		
	}

	void sumList(Node n1, Node n2) {
		int rem = 0;
		int carry = 0;
		int d = 0;
		while (n1 != null && n2 != null) {
			d = n1.data + n2.data + carry;
			if (d >= 10) {
				rem = d % 10;
				carry = d / 10;
			} else {
				rem = d;
			}
//			push(rem);
			append(rem);
			n1 = n1.next;
			n2 = n2.next;
		}
	}
	void append(int data) {
		Node new_node=new Node(data);
		if(head==null) {
			head=new_node;
			return;
		}
		Node n=head;
		while(n.next!=null) {
			n=n.next;
		}
		n.next=new_node;
	}
	void push(int data) {
		Node new_node=new Node(data);
		new_node.next=head;
		head=new_node;
	}

	void printList(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

}

class Node {
	int data;
	Node next;

	public Node(int d) {
		data = d;
		next = null;
	}
}
