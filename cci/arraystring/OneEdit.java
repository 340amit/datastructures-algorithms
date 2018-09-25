//pales,pale -> true ; pale,ple -> true ; pale,bae -> false

package amit.cci.arraystring;

public class OneEdit {

	public static void main(String[] args) {
		String s1="pale";
		String s2="bae";
		System.out.println(""+oneEditAway(s1,s2));

	}
	
	static boolean oneEditAway(String str1,String str2) {
		if(str1.length()==str2.length()) {
			return replace(str1,str2);
		}else if(str1.length()+1==str2.length()) {
			return insert(str1,str2);
		}else if(str1.length()-1==str2.length()){
			return insert(str2,str1);
		}
		return false;
	}
	
	static boolean replace(String s1,String s2) {
		boolean foundDiff=false;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i) != s2.charAt(i+1)) {
				if(foundDiff) {
					return false;
				}
				foundDiff=true;
			}
		}
		return true;
	}
	
	static boolean insert(String s1,String s2) {
		int index1=0;
		int index2=0;
		while(index2 < s2.length() && index1 < s1.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if(index1!=index2) {
					return false;
				}
				index2++;
			}else {
				index1++;
				index2++;
			}
		}
		return true;
	}

}
