package amit.cci.arraystring;

public class StringRotation {

	public static void main(String[] args) {
		String s1="waterbottle";
		String s2="erbottlewat";
//		String s2="xyzxyzxyzxy";
		System.out.println(isSubString(s1,s2));

	}
	
	static boolean isSubString(String s1,String s2) {
		int l1=s1.length();
		int l2=s2.length();
		if(l1!=l2) {
			return false;
		}
		int i=0;
		int j=0;
		String temp="";
		while(i<l1) {
			if(s1.charAt(i)!=s2.charAt(j)) {
				temp=temp+s1.charAt(i);
				i++;
			}else {
				i++;
				j++;
			}
		}
		int k=0;
		while(k<temp.length()) {
			if(temp.charAt(k)!=s2.charAt(j)) {
				return false;
			}else {
				k++;
				j++;
			}
		}
		return true;
	}

}
