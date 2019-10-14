package cci.recursion;

public class ReverseTest {

	public static void main(String[] args) {
		ReverseTest rt=new ReverseTest();
		String s="abcd";
		char[] str= s.toCharArray();
		rt.printReverse(str);

	}
	
	public void printReverse(char[] str) {
		int l=str.length-1;
		helper(l,str);
	}
	public void helper(int index,char[] str) {
		if(str==null|| index<0) return;
		
		System.out.println(str[index]);
		helper(index-1,str);
		
				
	}

}
