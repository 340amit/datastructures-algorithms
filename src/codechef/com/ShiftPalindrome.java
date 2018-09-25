/*You are given a string S. A cyclic shift of S is a string formed by moving a number of 
characters from the beginning of S to its end (in the same order). Formally, 
for an integer k (0≤k<N), the k-th cyclic shift is a string R with length N such that:

Ri=Si+k for each 1≤i≤N−k
Ri=Si−N+k for each N−k+1≤i≤N
A string is palindromic if it is equal to its own reverse string.

Compute the number of palindromic cyclic shifts of the given string.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains a single string S.
Output
For each test case, print a single line containing one integer — the number of palindromic shifts.

Constraints
1≤T≤1,000
1≤|S|≤2⋅105
|S| contains only lowercase English letters
the sum of |S| in all test cases does not exceed 2⋅105
Subtasks
Subtask #1 (20 points): the sum of |S| in all test cases does not exceed 100
Subtask #2 (20 points): the sum of |S| in all test cases does not exceed 5,000
Subtask #3 (60 points): original constraints

Example Input
1
aabb
Example Output
2
Explanation
Example case 1: The two palindromic cyclic shifts of "aabb" are "abba" and "baab".*/

package codechef.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShiftPalindrome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test > 0) {
			String input = br.readLine();
			String r = input;
			int count = 0;
			for (int i = 0; i < input.length(); i++) {
				r = rotateByOne(r);
				if (isPalindrome(r)) {
					count++;
				}
			}
			System.out.println(count);
			test--;
		}
	}

	public static String rotateByOne(String r) {
		char[] a = r.toCharArray();
		char x = a[0];
		int i;
		for (i = 0; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		a[i] = x;
		return new String(a);
	}

	public static boolean isPalindrome(String p) {
		char[] a = p.toCharArray();
		int l = 0;
		int r = a.length - 1;
		while (l < r) {
			if (a[l] != a[r]) {
				return false;
			} else {
				l++;
				r--;
			}
		}
		return true;
	}

}
