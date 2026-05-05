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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k==0) return head;

        int n = 0;
        ListNode node = head;
        while(node != null){
            n++;
            node = node.next;
        }

        k = k%n;
        if (k == 0) return head;
        int l = n-k;
        ListNode newTail = head;
        ListNode newHead = null;
        for (int i=1; i<l; i++){
            newTail = newTail.next;
        }
        newHead = newTail.next;
        newTail.next = null;

        ListNode temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;

        return newHead;
    }
}