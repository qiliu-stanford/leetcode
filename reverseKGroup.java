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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        ListNode dummy = new ListNode(0);
        ListNode prev, cur, tmp, start, end;
        int cnt;
        prev = dummy;
        dummy.next = head;
        start = dummy;
        cnt = 0;
        while (head != null) {   
            if (cnt < k - 1) {
                cnt++;
                head = head.next;
            } else {
                tmp = start.next;
                start.next = head;
                start = tmp;
                prev = head.next;
                cur = start;
                while (cur != head) {
                    tmp = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = tmp;
                }
                cnt = 0;
                tmp = head.next;
                head.next = prev;
                head = tmp;
                
            }
        }
        return dummy.next;
    }
}