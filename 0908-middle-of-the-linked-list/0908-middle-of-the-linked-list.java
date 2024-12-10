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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        if (temp==null){
            return null;
        }
        int ctr=0;
        while (temp != null){
            temp=temp.next;
            ctr++;
        }
        int mid = ctr/2;
        // mid++;
        ctr=0;
        while (ctr!=mid){
            head = head.next;
            ctr++;
        }
        return head;
    }
}