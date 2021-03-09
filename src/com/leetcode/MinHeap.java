package com.leetcode;

import java.util.PriorityQueue;

public class MinHeap {
	
	private int size = 0;
	private int k = 0;
	private PriorityQueue<Integer> heap;

	public MinHeap(int k, int[] nums) {
		this.k = k;
		heap = new PriorityQueue<>(k);
		for (int num : nums) {
			add(num);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int add(int val) {
		if (size == k) {
			int min = heap.peek();
			if (val > min) {
				heap.poll();
				heap.offer(val);
			}
		} else {
			heap.offer(val);
			size++;
		}
		return heap.peek();
	}
}