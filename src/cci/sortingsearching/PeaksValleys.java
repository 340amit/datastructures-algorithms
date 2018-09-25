package cci.sortingsearching;

import java.util.Arrays;

public class PeaksValleys {

	public static void main(String[] args) {
		int raw[] = { 9, 1, 0, 4, 8, 7 };
		System.out.println(Arrays.toString(raw));
		// System.out.println(Arrays.toString(getPeakValley(raw)));
		System.out.println(Arrays.toString(getPeakValleyOptimised(raw)));

	}

	static int[] getPeakValley(int[] raw) {
		// nlogn
		Arrays.sort(raw);
		for (int i = 1; i < raw.length; i += 2) {
			swap(raw, i - 1, i);
		}
		return raw;
	}

	static void swap(int[] input, int l, int r) {
		int temp = input[l];
		input[l] = input[r];
		input[r] = temp;
	}

	static int[] getPeakValleyOptimised(int[] raw) {
		for (int i = 1; i < raw.length; i += 2) {
			int biggestIndex = biggestIndex(raw, i - 1, i, i + 1);
			if (i != biggestIndex) {
				swap(raw, i, biggestIndex);
			}
		}
		return raw;
	}

	static int biggestIndex(int[] input, int a, int b, int c) {
		int len = input.length;
		int aVal = a >= 0 && a < len ? input[a] : Integer.MIN_VALUE;
		int bVal = b >= 0 && b < len ? input[b] : Integer.MIN_VALUE;
		int cVal = c >= 0 && c < len ? input[c] : Integer.MIN_VALUE;
		int max = Math.max(aVal, Math.max(bVal, cVal));

		if (max == aVal)
			return a;
		else if (max == bVal)
			return b;
		else
			return c;

	}

}
