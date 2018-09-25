/*Chef is learning linear algebra. Recently, he learnt that for a square matrix M, trace(M) is defined as the sum of all elements on the main diagonal of M (an element lies on the main diagonal if its row index and column index are equal).

Now, Chef wants to solve some excercises related to this new quantity, so he wrote down a square matrix A with size N×N. A square submatrix of A with size l×l is a contiguous block of l×l elements of A. Formally, if B is a submatrix of A with size l×l, then there must be integers r and c (1≤r,c≤N+1−l) such that Bi,j=Ar+i−1,c+j−1 for each 1≤i,j≤l.

Help Chef find the maximum trace of a square submatrix of A.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N.
N lines follow. For each i (1≤i≤N), the i-th of these lines contains N space-separated integers Ai,1,Ai,2,…,Ai,N denoting the i-th row of the matrix A.
Output
For each test case, print a single line containing one integer — the maximum possible trace.

Constraints
1≤T≤100
2≤N≤100
1≤Ai,j≤100 for each valid i,j
Subtasks
Subtask #1 (100 points): original constraints

Example Input
1
3
1 2 5
6 3 4
2 7 1
Example Output
13
Explanation
Example case 1: The submatrix with the largest trace is

6 3
2 7
which has trace equal to 6+7=13. (This submatrix is obtained for r=2,c=1,l=2.)*/

package codechef.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSquareSubMatrix {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		while (testCase > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] matrix = new int[n][n];
			for (int r = 0; r < n; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					int val = Integer.parseInt(st.nextToken());
					System.out.print(val + " ");
					matrix[r][c] = val;
				}
				System.out.println();
			}
			printMatrix(matrix);
			maxTraceSubMatrix(matrix);
			testCase--;
		}

	}

	public static int maxTraceSubMatrix(int[][] matrix) {
		int n = matrix.length;
		int sum = 0;
		int max = 0;
		for (int r = 0; r < n - 1; r++) {
			for (int c = 0; c < n - 1; c++) {
				sum = matrix[r][c] + matrix[r + 1][c + 1];
				System.out.println(sum);
				max = Math.max(sum, max);
			}
		}
		System.out.println("max:" + max);
		return max;
	}

	public static void printMatrix(int[][] matrix) {
		int n = matrix.length;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int val = matrix[r][c];
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}
