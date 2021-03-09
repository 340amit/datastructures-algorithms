package cci.arraystring;

import java.util.Arrays;

public class PalindromeNumber {

	public static void main(String[] args) {
		int x = 1221;
		char[] arr = ("" + x).toCharArray();
		System.out.println(Arrays.toString(arr));

	}

	public boolean isPalindrome(int x) {
		char[] arr = ("" + x).toCharArray();
		System.out.println(Arrays.toString(arr));

		int l = 0;
		int r = arr.length - 1;
		while (l < r) {
			if (arr[l] != arr[r]) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	
	 public boolean isPalindrome(String s) {
	        
	        if(s!=null && s.length()>1){
	            int start=0;
	            int end = s.length()-1;
	            while(start<end){
	                if(Character.isWhitespace(s.charAt(start))|| !Character.isLetterOrDigit(s.charAt(start))) start++;
	                if(Character.isWhitespace(s.charAt(end))|| !Character.isLetterOrDigit(s.charAt(end))) end--;
	                if(Character.toLowerCase(start) != Character.toLowerCase(end)) return false;
	            }
	        }
	        return true;
	    }

}
