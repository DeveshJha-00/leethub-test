/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (node1, node2) -> node1.val - node2.val
        );

        for(ListNode node : lists) {
            if(node != null) minHeap.offer(node);
        }
        if (minHeap.isEmpty()) return null;

        ListNode head = minHeap.poll();
        if (head.next != null) minHeap.offer(head.next);

        ListNode prev = head;
        
        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();

            prev.next = curr;
            prev = curr;

            if (curr.next != null) minHeap.offer(curr.next);
        }

        return head;
    }
}