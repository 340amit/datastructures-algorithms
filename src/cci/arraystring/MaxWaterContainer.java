package cci.arraystring;

public class MaxWaterContainer {

	public static void main(String[] args) {
		int a[] = { 1, 5, 4, 3 };
		System.out.println(maxWater(a));

	}

	static int maxWater(int a[]) {
		int len = a.length;
		int max = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int area;
				if (a[i] <= a[j]) {
					area = a[i] * (j - i);
				} else {
					area = a[j] * (j - i);
				}
				if (area > max) {
					max = area;
				}
			}
		}
		return max;
	}

}
