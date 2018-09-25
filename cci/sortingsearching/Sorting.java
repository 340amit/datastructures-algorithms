package amit.cci.sortingsearching;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		Sorting s=new Sorting();
		int a[] = {23,25,12,22,11};
//		System.out.println(s.bs(a, 12, 0, a.length-1));
//		int b[]= {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
//		System.out.println(s.findPivotBS(b, 0, b.length-1));
		
//		System.out.println(s.findInSortedRotatedAray(b,2));
//		s.print(a);
		
//		s.bubbleSort(a);
//		s.selectionSort(a);
		s.mergeSort(a, 0, a.length-1);
//		s.quickSort(a, 0, a.length-1);
		s.print(a);
		
		
		

	}
	
	void print(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	void bubbleSort(int[] a) {
		int n=a.length-1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	void selectionSort(int[] a) {
		int n=a.length;
		for(int i=0;i<n-1;i++) {
			int min=i;
			for(int j=i+1;j<n;j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			int temp=a[min];
			a[min]=a[i];
			a[i]=temp;
		}
	}
	
	void mergeSort(int[] a,int l,int r) {
		if(l<r) {
			int m=(l+r)/2;
			mergeSort(a,l,m);
			mergeSort(a,m+1,r);
			merge(a,l,m,r);
		}
		
	}
	void merge(int[] a,int l,int m,int r) {
		int n1=m-l+1;
		int n2=r-m;
		int[] L=new int[n1];
		int[] R=new int[n2];
		
		for(int i=0;i<n1;i++) {
			L[i]=a[l+i];
		}
		System.out.println(Arrays.toString(L));
		for(int j=0;j<n2;j++) {
			R[j]=a[m+1+j];
		}
		System.out.println(Arrays.toString(R));
		int i=0,j=0;
		int k=l;
		while(i<n1 && j<n2) {
			if(L[i]<=R[j]) {
				a[k]=L[i];
				k++;
				i++;
			}else {
				a[k]=R[j];
				j++;
				k++;
			}
		}
		
		while(i<n1) {
			a[k]=L[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			a[k]=R[j];
			j++;
			k++;
		}
		
	}
	
	void quickSort(int[] a,int l,int h) {
		if(l<h) {
			int pi=partition(a,l,h);
			quickSort(a,l,pi-1);
			quickSort(a,pi+1,h);
		}
	}
	
	int partition(int[] a,int l,int h) {
		int pivot=a[h];
		int i=l-1;
		for(int j=l;j<h;j++) {
			if(a[j]<=pivot) {
				i++;
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		int temp=a[i+1];
		a[i+1]=a[h];
		a[h]=temp;
		
		return i+1;
	}
//	{4,5, 6, 7, 8, 9, 10, 1, 2, 3};	
	int findPivotBS(int[] a,int l,int r) {
		while(l<=r) {
			int mid=(l+r)/2;
			if(a[mid]>a[mid+1]) {
				return mid+1;
			}else if(a[l]<=a[mid]) { //left sorted
				l=mid+1;
			}else {					//right sorted
				r=mid-1;
			}
		}
		return -1;
	}
	
	int bs(int a[],int x,int l,int r) {
		while(l<=r) {
			int mid=(l+r)/2;
			if(a[mid]==x) {
				System.out.println("mid:"+mid);
				return mid;
			}else if(a[mid]<x) {
				l=mid+1;
			}else {
				r=mid-1;
			}
		}
		return -1;
	}
//	{4,5, 6, 7, 8, 9, 10, 1, 2, 3};	
	int findInSortedRotatedAray(int a[],int x) {
		int l=0;
		int r=a.length-1;
		int pivot=findPivotBS(a,l,r);
		System.out.println("pivot:"+pivot+":"+a[pivot]);
		if(a[pivot]==x) {
			return pivot;
		}else if(a[l]<=x && a[pivot-1]>=x){ // l to pivot-1
			return bs(a,x,l,pivot-1);
		}else if(a[pivot+1]<=x && a[r]>=x){  // pivot+1 to r 
			return bs(a,x,pivot+1,r);
		}
		return -1;
	}

}
