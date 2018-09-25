package amit.cci.arraystring;

import java.io.IOException;

public class StringCompression {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.out.println(strCompression("aaaaaabb"));
		// int a[]= {1,2,3,4,5,6,7,6,5,4,3,2,1,1};
		
	}

	

	static String strCompression(String s) {
		int count = 0;
		StringBuilder str = new StringBuilder();
		int i;
		for (i = 0; i < s.length(); i++) {
			count++;
			if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
				str.append(s.charAt(i));
				str.append(count);
				count = 0;
			}
		}
		return str.toString().length() < s.length() ? str.toString() : s;
	}

}
