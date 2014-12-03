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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy, tmp, next;
        dummy.next = head;
        while ((cur.next != null) && (cur.next.next != null)) {
            tmp = cur.next;
            next = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = tmp;
            tmp.next = next;
            cur = tmp;
        }
        return dummy.next;
    }
}