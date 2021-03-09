package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {

	public static void main(String[] args) {
		int[][] prerequisites = {{1,0}};
		int numCourses = 2;
		System.out.println(canFinish(numCourses, prerequisites));

	}
	
	 public static boolean canFinish(int numCourses, int[][] prerequisites) {
	        
	        int[] degree = new int[numCourses];
	        
	        for(int i =0; i< prerequisites.length; i++){
	            degree[prerequisites[i][0]]++;
	        }
	        
	        Stack<Integer> st = new Stack<>();
	        
	        for(int i =0; i< numCourses; i++){
	            if(degree[i] == 0) {
	                st.push(i);
	            }
	        }
	        
	        int count = 0;
	        List<Integer> list = new ArrayList<>();
	        while(!st.isEmpty()){
	            int curr = st.pop();
	            count++;
	            list.add(curr);
	            for(int i =0; i< prerequisites.length; i++){
	                if(prerequisites[i][1] == curr){
	                    degree[prerequisites[i][0]]--;
	                    if(degree[prerequisites[i][0]] == 0){
	                        st.push(prerequisites[i][0]);
	                    }
	                }
	            }
	        }
	        
	        if(count == numCourses) {
	        		int[] output = list.stream().mapToInt(i -> i).toArray();
	        }
	        
	        System.out.println(list);
	        
	        return count == numCourses;
	    }
}
