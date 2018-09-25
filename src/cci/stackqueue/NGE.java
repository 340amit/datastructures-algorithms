package cci.stackqueue;

import java.util.Stack;

//Java program to print next
//greater element using stack

public class NGE {
	static class stack {
		int top;
		int items[] = new int[100];

		// Stack functions to be used by printNGE
		void push(int x) {
			if (top == 99) {
				System.out.println("Stack full");
			} else {
				items[++top] = x;
			}
		}

		int pop() {
			if (top == -1) {
				System.out.println("Underflow error");
				return -1;
			} else {
				int element = items[top];
				top--;
				return element;
			}
		}

		boolean isEmpty() {
			return (top == -1) ? true : false;
		}
	}

	/*
	 * prints element and NGE pair for all elements of arr[] of size n
	 */
	static void printNGE(int arr[], int n) {
		int i = 0;
		stack s = new stack();
		s.top = -1;
		int element, next;

		/* push the first element to stack */
		s.push(arr[0]);

		// iterate for rest of the elements
		for (i = 1; i < n; i++) {
			next = arr[i];

			if (s.isEmpty() == false) {

				// if stack is not empty, then
				// pop an element from stack
				element = s.pop();

				/*
				 * If the popped element is smaller than next, then a) print the pair b) keep
				 * popping while elements are smaller and stack is not empty
				 */
				while (element < next) {
					System.out.println(element + " --> " + next);
					if (s.isEmpty() == true)
						break;
					element = s.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (element > next)
					s.push(element);
			}

			/*
			 * push next to stack so that we can find next greater for it
			 */
			s.push(next);
		}

		/*
		 * After iterating over the loop, the remaining elements in stack do not have
		 * the next greater element, so print -1 for them
		 */
		while (s.isEmpty() == false) {
			element = s.pop();
			next = -1;
			System.out.println(element + " -- " + next);
		}
	}

	/*
	 * Algorithm: 1. Create a stack and push first element to it 2. Go through
	 * remaining elements 2.1 While stack is not empty and current element is
	 * greater than top of stack 2.1.1 Print current element as “Next Greater
	 * Element” for element at the top of stack 2.2 Push current element to the top
	 * of the stack 3. For all the elements left in stack, print “Next Greater
	 * Element” as -1
	 */

	public static void printNGE2(int[] a) {
		int n = a.length;
		Stack<Integer> s = new Stack<Integer>();
		s.push(a[0]);

		for (int i = 1; i < n; i++) {
			while (!s.isEmpty() && a[i] > s.peek())
				System.out.println(s.pop() + " ---> " + a[i]);
			s.push(a[i]);
		}

		while (!s.isEmpty())
			System.out.println(s.pop() + " ---> " + -1);
	}

	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 };
		// int arr[] ={4, 5, 2, 25};
		int n = arr.length;
		printNGE(arr, n);
		System.out.println("NGE2");
		printNGE2(arr);
	}
}
