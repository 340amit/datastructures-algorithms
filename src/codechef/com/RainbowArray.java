//https://www.codechef.com/problems/RAINBOWA
package codechef.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RainbowArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int noElements = Integer.parseInt(br.readLine());
			int[] elements = new int[noElements];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < noElements; j++) {
				elements[j] = Integer.parseInt(st.nextToken());
			}
			if (!validInput(elements)) {
				System.out.println("no");
			} else {
				if (!isMirror(elements)) {
					System.out.println("no");
				} else {
					System.out.println("yes");
				}
			}
		}
	}

	static boolean isMirror(int[] a) {
		int l = a.length;
		for (int i = 0; i < l; i++) {
			int start = i;
			int end = --l;
			if (start < end) {
				if (a[start] != a[end]) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean validInput(int[] a) {
		int l = a.length;
		int[] valid = new int[8];
		valid[0] = 1;
		for (int i = 0; i < l; i++) {
			if (a[i] == 1 || a[i] == 2 || a[i] == 3 || a[i] == 4 || a[i] == 5 || a[i] == 6 || a[i] == 7) {
				valid[a[i]] = 1;
			} else {
				return false;
			}
		}
		int count = 0;
		for (int k = 0; k < 8; k++) {
			if (valid[k] == 1) {
				count++;
			}
		}
		return count == 8 ? true : false;
	}

}
