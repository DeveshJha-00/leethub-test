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

    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;

        ListNode prev = null;
        while (head != null){
            ListNode nextNode = head.next;
            head.next=prev; //reverse the link
            prev=head; //move prev forward
            head=nextNode; //move head forward
        }
        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || head.next==null) return null;

        //reverse
        ListNode prev=reverseList(head);

        ListNode temp = prev;
        ListNode preTemp=prev;
        int ct=1;
        if (n==1){
            prev=prev.next;
        }else{
            while (ct!=n){
                preTemp=temp;
                temp=temp.next;
                ct++;
            }
            preTemp.next=temp.next;
        }

        //reverse
        return reverseList(prev);
    }
}