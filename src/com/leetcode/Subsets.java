package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println("Result:\n"+subsets(nums));

	}
	
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        System.out.println("Output:"+output);
        
        int s = 0;
        for(int n: nums) {
        		s = output.size();
        		for(int i=0; i<s; i++) {
        			List<Integer> current = new ArrayList<>(output.get(i));
        			current.add(n); // new decision
        			System.out.println("Current:"+ current);
        			output.add(current); // add to previous decision
        		}
        }
        
        return output;
    }

}
