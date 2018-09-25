package cci.arraystring;

public class Segreggate01 {

	public static void main(String[] args) {
		int a[] = { 1, 0, 0, 1, 1, 0, 2, 2, 1, 2 };
		int b[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int c[] = { 1, 3, 2, 4, 7, 6, 9, 10 };
		Segreggate01 sg = new Segreggate01();
		sg.printArray(a);
		// sg.sg01(a);
		sg.sgCount01(a);
		sg.printArray(a);

		sg.printArray(b);
		sg.rearrangePosNeg(b);
		sg.printArray(b);

		sg.printArray(c);
		sg.sgEvenOdd(c);
		sg.printArray(c);

	}

	public void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public void sg01(int a[]) {
		int i = -1;
		int j, temp;
		for (j = 0; j < a.length; j++) {
			if (a[j] == 0) {
				i++;
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}

	public void sgEvenOdd(int a[]) {
		int i = -1;
		int j, temp;
		for (j = 0; j < a.length; j++) {
			if (a[j] % 2 == 0) {
				i++;
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}

	public void sgCount01(int a[]) {
		int count[] = new int[3];
		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}
		int j = 0;
		int k = 0;
		while (k < a.length) {
			a[k] = j;
			k++;
			count[j]--;
			if (count[j] == 0) {
				j++;
			}
		}
	}

	public void rearrangePosNeg(int a[]) {
		int i = -1;
		int j;
		int temp;
		for (j = 0; j < a.length; j++) {
			if (a[j] < 0) {
				i++;
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int pos = i + 1;
		int neg = 0;
		while (pos < a.length && neg < pos && a[neg] < 0) {
			temp = a[neg];
			a[neg] = a[pos];
			a[pos] = temp;
			neg += 2;
			pos++;
		}
	}

}
