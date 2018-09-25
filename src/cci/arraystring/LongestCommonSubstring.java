package amit.cci.arraystring;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s1="cabaa";
		String s2="aabac";
		System.out.println(longComSubStr(s1,s2));
		
		System.out.println(lcsO3(s1,s2));

	}
	
	static int lcsO3(String s1,String s2) {
		int m=s1.length();
		int len=0;
		for(int i=0;i<m;i++) {
			String sub="";
			for(int j=i;j<m;j++) {
				sub=sub+s1.charAt(j);
				if(s2.contains(sub)) {
					int temp=sub.length();
					if(len<temp) {
						len=temp;
					}
				}
			}
		}
		return len;
	}
	
	static int longComSubStr(String s1,String s2) {
		int m=s1.length();
		int n=s2.length();
		int len=0;
		int row=0;
		int col=0;
		int lcs[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					lcs[i][j]=0;
				}else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					lcs[i][j]=lcs[i-1][j-1]+1;
					if(len<lcs[i][j]) {
						len=lcs[i][j];
						row=i;
						col=j;
						
					}
				}
			}
		}
		if(len==0) {
			System.out.println("No LCS");
		}
		while(lcs[row][col]!=0) {
			System.out.print(s1.charAt(row-1)+"");
			row--;
			col--;
		}
		System.out.println();
		return len;
	}

}
