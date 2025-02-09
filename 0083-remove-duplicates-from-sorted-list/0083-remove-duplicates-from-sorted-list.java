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
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;

        // ListNode temp=head;
        ListNode prev=head;
        ListNode dummy = new ListNode(-1,prev);
        ListNode temp=head.next;
        while(temp!=null){
            if(prev.val==temp.val){
                temp=temp.next;
            }else{
                prev.next=temp;
                prev=temp;
                temp=temp.next;
            }
        }
        prev.next=temp;

        return dummy.next;
    }
}