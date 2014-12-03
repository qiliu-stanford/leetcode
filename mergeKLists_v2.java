public class Solution {
    private class compareListNode implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            if (a == null) return -1;
            if (b == null) return 1;
            return (a.val - b.val);
        }
    }
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new compareListNode());
        for (ListNode a : lists) {
            if (a != null) pq.add(a);
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (pq.isEmpty() == false) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        return head.next;
    }
}