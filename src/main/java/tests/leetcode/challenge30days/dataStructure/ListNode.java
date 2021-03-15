package tests.leetcode.challenge30days.dataStructure;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode current = this;
        while(current != null) {
            stringBuilder.append(" " + current.val);
            current = current.next;
        }
        return stringBuilder.toString();
    }
}
