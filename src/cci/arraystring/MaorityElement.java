package cci.arraystring;

import java.util.HashMap;
import java.util.Map;

public class MaorityElement {

	public static void main(String[] args) {
		MaorityElement me = new MaorityElement();
		int[] input = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(me.majorityElement2(input));

	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> data = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (data.containsKey(nums[i])) {
				data.put(nums[i], data.get(nums[i]) + 1);
			} else {
				data.put(nums[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> m : data.entrySet()) {
			if (m.getValue() >= (nums.length / 2))
				return m.getKey();
		}
		return -1;
	}

	public int majorityElement2(int nums[]) {
		int candidate = nums[0];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (candidate == nums[i]) {
				count++;
			} else {
				count--;
				if (count < 0) {
					candidate = nums[i];
					count = 1;
				}
			}
		}
		return candidate;
	}

}
