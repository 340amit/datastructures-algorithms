package cci.stackqueue;

import java.util.EmptyStackException;

public class MyStack<T> {
	private StackNode<T> top;

	public static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		MyStack<Integer> p = new MyStack<>();
		p.push(new Integer(10));
		p.push(new Integer(20));
		p.push(new Integer(30));
		System.out.println(p.peek());
		p.print();
		p.pop();
		p.print();

	}

	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isempty() {
		return top == null;
	}

	public void print() {
		if (top == null)
			throw new EmptyStackException();
		StackNode<T> current = top;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

}
