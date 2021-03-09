package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		String s = "cars";
		/*String word = "apple";
		
		String before = s.substring(0, s.indexOf(word));
		String after = s.substring(s.indexOf(word) + word.length(),s.length());
		System.out.println("Result:"+before);
		System.out.println("Result:"+after);
		*/
//		System.out.println("sand".contains("sand"));
		
		List<String> wordDict = new ArrayList<>();
		wordDict.add("car");
		wordDict.add("ca");
		wordDict.add("rs");
//		wordDict.add("and");
//		wordDict.remove(0);
//		System.out.println(wordDict.get(0));
//		wordDict.remove(0);
//		System.out.println(wordDict.get(0));
		
		System.out.println("IsInList:"+wordBreak(s,wordDict));
		
	}
	
	 public static boolean wordBreak(String s, List<String> wordDict) {
			Set<String> words = new HashSet<>(wordDict);
			boolean[] dp = new boolean[s.length()+1];
			dp[0] = true;
			for(int len = 1; len <= s.length(); len++) {
				for(int j = 0; j<len; j++) {
					if(dp[j] && words.contains(s.substring(j, len))) {
						dp[len] = true;
					}
				}
			}
			return dp[s.length()];
		}
	
//applepenapple --- [apple, pen]	
	public static boolean wordBreak1(String s, List<String> wordDict) {
		boolean found = false;
		String temp = s;
		while(!wordDict.isEmpty() && !found) {
			String deleteFound = "";
			int i = 0;
			while (i < wordDict.size()) {
				String word = wordDict.get(i);
				System.out.println(word);
				if (s.contains(word)) {
					deleteFound = word;
					System.out.println("Before i:"+i+"="+s);
					String x = s.substring(0, s.indexOf(word));
					System.out.println("X:"+x);
					String y = s.substring(s.indexOf(word) + word.length(), s.length());
					System.out.println("Y:"+y);
					s = x + y;
					i = 0;
					System.out.println("After i:"+i+"="+s);
				}else i++;
				
				if(s.isEmpty()) {
					found = true;
				}
			}
			if(!found) {
				wordDict.remove(deleteFound);
				s=temp;
			}
		}
		return found;
	}
	 
	String extractSubString(String parent, String child) {
		return "";
	}

}
