package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class LRUCache {

	Map<Integer, Integer> cache;
	int maxCapacity;

	public LRUCache(int capacity) {
		cache = new LinkedHashMap<>();
		maxCapacity = capacity;
	}

	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;
		int value = cache.get(key);
		cache.remove(key);
		cache.put(key, value);
		return value;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		} else {
			if (maxCapacity > 0 && cache.size() == maxCapacity) {
				int firstKey = cache.keySet().iterator().next();
				cache.remove(firstKey);
			}
		}
		cache.put(key, value);
	}
}
