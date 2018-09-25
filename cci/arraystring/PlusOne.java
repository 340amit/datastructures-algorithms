package amit.cci.arraystring;

import java.util.Arrays;

public class PlusOne {
	public static void main(String args[]) {
		PlusOne p=new PlusOne();
		int[] digits= {8,9,9,9};
		p.plusOne(digits);
		System.out.println(Arrays.toString(digits));
	}
	 public int[] plusOne(int[] digits) {
	        int l=digits.length-1;
	        reverse(digits);
	        int carry=0;
	        digits[0]=digits[0]+1;
	        if(digits[0]>=10){
	            carry=digits[0]/10;
	            digits[0]=digits[0]%10;
	        }
	        for(int i=1;i<=l;i++){
	            digits[i]=digits[i]+carry;
	            if(digits[i]>=10){
	            carry=digits[i]/10;
	            digits[i]=digits[i]%10;
	        }else {
	        	carry=0;
	        }
	        }
	        if(carry>0){
	            int[] a=new int[l+2];
	            int j;
	            for(j=0;j<=l;j++){
	                a[j]=digits[j];
	            }
	            a[j]=carry;
	            return reverse(a);
	        }
	        
	        return reverse(digits);
	    }
	    
	    public int[] reverse(int[] a){
	        int n=a.length-1;
	        for(int i=0;i<=n/2;i++){
	            int temp=a[i];
	            a[i]=a[n-i];
	            a[n-i]=temp;
	        }
	        System.out.println(Arrays.toString(a));
	        return a;
	    }

}
