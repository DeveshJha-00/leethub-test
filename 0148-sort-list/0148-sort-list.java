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
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head; //base case

        ListNode middle = findMiddle(head);
        ListNode left = head , right=middle.next;
        middle.next=null;
        
        left = sortList(left);
        right = sortList(right);
        return mergeList(left,right);
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow=head, fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (left!=null && right!=null){
            if (left.val < right.val){
                temp.next=left;
                temp=left;
                left=left.next;
            }else{
                temp.next=right;
                temp=right;
                right=right.next;
            }
        }
        while(left!=null){
            temp.next=left;
            temp=left;
            left=left.next;
        }
        while(right!=null){
            temp.next=right;
            temp=right;
            right=right.next;
        }
        // if (left!=null) temp.next=left;
        // else temp.next=right;
        return dummy.next;
    }

}