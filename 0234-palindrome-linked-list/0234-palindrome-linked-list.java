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
    public ListNode reverse(ListNode curr){
        ListNode prev=null;
        while (curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {

        //APPROACH 1 -> STACK
        //APPROACH 2 -> FIND MIDDLE, REVERSE AND COMPARE
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null && fast.next.next!=null){ //odd and even length cases respc.
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid = slow.next;
        ListNode newHead = reverse(mid);
        //ListNode newHead = reverse(slow.next); can be done as well
        ListNode first=head;
        ListNode second=newHead;
        while (second!=null){
            if (first.val != second.val) return false;
            first=first.next;
            second=second.next;
        }
        return true;
    }
}