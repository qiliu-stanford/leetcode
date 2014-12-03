/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);
        int mid = lists.size() / 2;
        ListNode first, second, result, cur;
        first = mergeKLists(lists.subList(0, mid));
        second = mergeKLists(lists.subList(mid, lists.size()));
        
        result = new ListNode(0);
        cur = result;
        while ((first != null) && (second != null)) {
            if (first.val < second.val) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        if (first != null) {
            cur.next = first;
        }
        if (second != null) {
            cur.next = second;
        }
        return result.next;
    }
}