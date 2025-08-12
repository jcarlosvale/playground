package ada;

import tests.leetcode.challenge30days.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> superList = new ArrayList<>();
        for(ListNode l : lists) {
            while(l != null) {
                superList.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(superList);
        if (superList.size() == 0) return null;
        ListNode ans = new ListNode(superList.get(0));
        ListNode next = ans;
        for (int i = 1; i < superList.size(); i++) {
            next.next = new ListNode(superList.get(i));
            next = next.next;
        }
        return ans;
    }
}
