/* 
2
5 1 1
1 1 1 1 1
2 1 1
1 2
Example Output
1.0000000000
0.2500000000
*/
package amit.codechef.com;

import java.util.Scanner;

public class Naichef {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();
		while(testCase>0) {
			int n=sc.nextInt();
			int totalOutcome=n;
			int a=sc.nextInt();
			int b=sc.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			print(arr);
			int countA=count(arr,a);
			System.out.println("CountA:"+countA);
			
			int countB=count(arr,b);
			System.out.println("CountB:"+countB);
			System.out.println("totalOutcome:"+totalOutcome);
	        double probA=new Double(countA)/new Double(totalOutcome);
			System.out.println("probA:"+probA);
			double probB=new Double(countB)/new Double(totalOutcome);
			System.out.println("probB:"+probB);
			
			double prob=probA*probB;
			System.out.println(String.format("%.10f", prob));
			double pi=new Double(22)/new Double(7);
			System.out.println(String.format("%.10f", pi));
			
			testCase--;
		}
		sc.close();

	}
	static int count(int arr[], int k) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==k)
				count++;
		}
		return count;
	}
	
	static void print(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
