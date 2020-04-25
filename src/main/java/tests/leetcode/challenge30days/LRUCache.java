package tests.leetcode.challenge30days;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 */
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1,1);
//        cache.put(2,2);
//        cache.get(1);       // returns 1
//        cache.put(3,3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4,4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4

public class LRUCache {
    private Map<Integer, Integer> mapValuesByIndex;
    private LinkedList<Integer> usage;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.usage = new LinkedList<>();
        this.mapValuesByIndex = new HashMap<>();
    }

    public int get(int key) {
        if (mapValuesByIndex.containsKey(key)) {
            if (usage.getLast() != key) {
                usage.remove(Integer.valueOf(key));
                usage.add(key);
            }
            return mapValuesByIndex.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(get(key) >= 0) {
            mapValuesByIndex.put(key, value);
        } else {
            if (usage.size() == capacity) {
                mapValuesByIndex.remove(usage.getFirst());
                usage.removeFirst();
            }
            usage.add(key);
            mapValuesByIndex.put(key,value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3,3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4,4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

        cache = new LRUCache(2);
        System.out.println(cache.get(2));       // returns -1
        cache.put(2,6);    // evicts key 2
        System.out.println(cache.get(1));       // returns -1
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));       // returns 2
        System.out.println(cache.get(2));       // returns 6


    }
}
