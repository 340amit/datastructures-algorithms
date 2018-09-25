package amit.cci.linkedlist;

public class LoopDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Node loopDetection(Node n) {
		Node slow=n;
		Node fast=n;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				break;
			}
		}
		
		if(fast==null || fast.next==null) return null;
		
		slow=n;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return fast;
	}

}
