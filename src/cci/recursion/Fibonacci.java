package cci.recursion;

import java.util.concurrent.TimeUnit;

public class Fibonacci {

	public static void main(String[] args) {
		/*
		 * long start1=System.nanoTime(); System.out.println("fib:"+fib(50)); long
		 * end1=System.nanoTime();
		 * System.out.println("Time nanosecs fib:"+(end1-start1)); long
		 * sec1=TimeUnit.NANOSECONDS.toSeconds(end1-start1);
		 * System.out.println("Time secs fib:"+sec1);
		 */

		long start3 = System.nanoTime();
		System.out.println("fibIter:" + fibIter(140));
		long end3 = System.nanoTime();
		System.out.println("Time nanosecs fibIter:" + (end3 - start3));
		long sec3 = TimeUnit.NANOSECONDS.toSeconds(end3 - start3);
		System.out.println("Time secs fibIter:" + sec3);

		long start2 = System.nanoTime();
		System.out.println("fibD:" + fibD(140));
		long end2 = System.nanoTime();
		System.out.println("Time nanosecs fibD:" + (end2 - start2));
		long sec = TimeUnit.NANOSECONDS.toSeconds(end2 - start2);
		System.out.println("Time secs fibD:" + sec);

		/* System.out.println("fac:"+fac(5)); */

	}

	static long fibIter(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		long fa = 0;
		long fb = 1;
		long temp = 0;
		for (int i = 2; i < n; i++) {
			temp = fa + fb;
			fa = fb;
			fb = temp;
		}
		return fa + fb;
	}

	static long fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	static long fibD(int n) {
		return fibTopDown(n, new long[n + 1]);
	}

	static long fibTopDown(int i, long[] memo) {
		if (i == 0 || i == 1)
			return i;
		if (memo[i] == 0) {
			memo[i] = fibTopDown(i - 1, memo) + fibTopDown(i - 2, memo);
		}
		return memo[i];
	}

	static int fac(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		return n * fac(n - 1);
	}

}
