package cci.arraystring;

public class MaxWaterContainer {

	public static void main(String[] args) {
//		int a[] = { 1, 5, 4, 3 };
		int a[] = { 3, 0, 0, 2, 0, 4};
		
		System.out.println(maxWater(a));
		
		System.out.println(maxWaterOptimised(a));

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
	//int a[] = { 3, 0, 0, 2, 0, 4};
	static int maxWaterOptimised(int a[]) {
		int len=a.length;
		int l=0;
		int r=len-1;
		int area=0;
		while(l<r) {
			area=Math.max(area, Math.min(a[l], a[r])*(r-l));
			if(a[l]<a[r]) {
				l+=1;
			}else {
				r-=1;
			}
		}
		return area;
	}

}
