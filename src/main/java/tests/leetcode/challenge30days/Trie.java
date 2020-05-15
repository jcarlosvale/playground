package tests.leetcode.challenge30days;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Trie {

    private Character value;
    private boolean end;
    private Map<Character, Trie> childList;

    /** Initialize your data structure here. */
    public Trie() {
        childList = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.isEmpty()) return;
        insert(this.childList, word);
    }

    private void insert(Map<Character, Trie> childMap, String word) {
        char c = word.charAt(0);
        if (childMap.containsKey(c)) {
            if (word.length() == 1) {
                childMap.get(c).end = true;
            } else {
                insert(childMap.get(c).childList, word.substring(1));
            }
        } else {
            Trie child = new Trie();
            child.value = c;
            child.end = (word.length() == 1);
            if (!child.end) {
                insert(child.childList, word.substring(1));
            }
            childMap.put(c, child);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.isEmpty()) return false;
        Trie lastNode = locateLastNode(this.childList, word);
        return (lastNode != null && lastNode.end);
    }

    private Trie locateLastNode(Map<Character, Trie> mapTries, String word) {
        if (mapTries.isEmpty()) return null;
        if (word.isEmpty()) return null;
        char c = word.charAt(0);
        if (mapTries.containsKey(c)) {
            if (word.length() == 1) {
                return mapTries.get(c);
            } else {
                Trie trie = mapTries.get(c);
                return locateLastNode(trie.childList, word.substring(1));
            }
        } else {
            return null;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return false;
        Trie lastNode = locateLastNode(this.childList, prefix);
        return (lastNode != null);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
