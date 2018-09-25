package amit.cci.linkedlist;

public class Palindrome {
	static Node head;
	static class Node{
		int data;
		Node next;
		public Node(int d) {
			data=d;
			next=null;
		}
	}

	public static void main(String[] args) {
		head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(3);
		head.next.next.next.next.next=new Node(2);
		head.next.next.next.next.next.next=new Node(1);
		
		Palindrome p=new Palindrome();
		p.printList(head);
		System.out.println("Palindrome:"+p.isPalindrom(head));

	}
	
	void printList(Node n) {
		Node n1=n;
		while(n1!=null) {
			System.out.print(n1.data+" ");
			n1=n1.next;
		}
		System.out.println();
	}
	
	boolean isPalindrom(Node n) {
		Node temp=n;
		int count =0;
		int rightR=0;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		System.out.println("Count:"+count);
		rightR=count/2;
		System.out.println("rightR:"+rightR);
		Node pointer1=n;
		Node pointer2=null;
		int tempCount=0;
		Node prev=null;
		while(pointer1!=null) {
			tempCount++;
			prev=pointer1;
			if(tempCount>=rightR) {
				if(count%2==0) {
					pointer2=prev.next;
				}else {
					pointer2=prev.next.next;
				}
				pointer1.next=null;
			}
			pointer1=pointer1.next;
		}
		Node t1=n;
		Node t2=reverse(pointer2);
		printList(t1);
		printList(t2);
		return isSame(t1,t2);
	}
	boolean isSame(Node n1,Node n2) {
		while(n1!=null && n2!=null) {
			if(n1.data==n2.data) {
				n1=n1.next;
				n2=n2.next;
			}else {
				break;
			}
		}
		if(n1==null && n2==null) {
			return true;
		}
		return false;
	}
//	d1|n1 -> d2|n2 -> d3|n3
	Node reverse(Node n) {
		Node current=n;
		Node prev=null;
		Node next=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		n=prev;
		return n;
	}

}
