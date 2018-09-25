package amit.cci.arraystring;

import java.util.Arrays;

public class PalindromeNumber {

	public static void main(String[] args) {
		int x=1221;
		char[] arr=(""+x).toCharArray();
		System.out.println(Arrays.toString(arr));

	}
	
	public boolean isPalindrome(int x) {
		char[] arr=(""+x).toCharArray();
		System.out.println(Arrays.toString(arr));
		
		int l=0;
		int r=arr.length-1;
		while(l<r) {
			if(arr[l]!=arr[r]) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	} 

}
