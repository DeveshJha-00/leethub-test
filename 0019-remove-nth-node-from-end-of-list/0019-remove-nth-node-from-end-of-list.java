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

    //APPROACH 1-> REVERSE, REMOVE NTH, REVERSE AGAIN AND RETURN (DONE)
    //APPROACH 2-> TRAVERSE TILL END AND FIND LENGTH (CT), TRAVERSE AGAIN TILL CT-N 
    //              AND REMOVE THAT NODE
    //APPROACH 3-> FAST AND SLOW PTR, MOVE FAST TILL NTH POSITION, THEN MOVE BOTH BY 1 EACH STEP

    // public ListNode reverseList(ListNode head) {
    //     if (head==null) return null;
    //     if (head.next==null) return head;

    //     ListNode prev = null;
    //     while (head != null){
    //         ListNode nextNode = head.next;
    //         head.next=prev; //reverse the link
    //         prev=head; //move prev forward
    //         head=nextNode; //move head forward
    //     }
    //     return prev;
    // }

    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     if (head==null || head.next==null) return null;

    //     //reverse
    //     ListNode prev=reverseList(head);

    //     ListNode temp = prev;
    //     ListNode preTemp=prev;
    //     int ct=1;
    //     if (n==1){
    //         prev=prev.next;
    //     }else{
    //         while (ct!=n){
    //             preTemp=temp;
    //             temp=temp.next;
    //             ct++;
    //         }
    //         preTemp.next=temp.next;
    //     }

    //     //reverse
    //     return reverseList(prev);
    // }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i=0; i<n; i++) fast=fast.next;
        if (fast == null){
            head=head.next;
            return head;
        }
        while (fast.next!=null && fast!=null){
            slow=slow.next;
            fast = fast.next;
        }
        
        slow.next=slow.next.next;
        return head;
    }
}