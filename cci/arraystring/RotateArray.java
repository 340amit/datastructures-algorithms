package geeksforgeeks.array;

public class RotateArray {
	
	public void leftRotate(int a[],int n,int d) {
		int i,j,k,temp;
		for(i=0;i<gcd(n,d);i++) {
			temp=a[i];
			j=i;
			while(true) {
				k=j+d;
				if(k>=n)
					k=k-n;
				if(k==i)
					break;
				a[j]=a[k];
				j=k;
			}
			a[j]=temp;
		}
	}
	
	public int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	
	public void leftRotateReversal(int a[],int n,int d) {
		reverse(a,0,d-1);
		reverse(a,d,n-1);
		reverse(a,0,n-1);
		
	}
	public void reverse(int a[],int l,int r) {
		int temp;
		while(l<r) {
			temp=a[l];
			a[l]=a[r];
			a[r]=temp;
			l++;
			r--;
		}
	}
	
	public void printArray(int[] a, int n) {
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
	}

	public static void main(String[] args) {
		RotateArray ra=new RotateArray();
		int a[]= {1,2,3,4,5,6,7};
		ra.leftRotate(a, 7, 2);
		ra.printArray(a, 7);
		System.out.println();
		int a1[]= {1,2,3,4,5,6,7};
		ra.leftRotateReversal(a1,7,2);
		ra.printArray(a1, 7);


	}

}
