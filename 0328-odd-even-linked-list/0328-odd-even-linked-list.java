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
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null) return head;

        // //BRUTE FORCE 
        // List<Integer> list = new ArrayList<>();
        // ListNode temp;
        // //STORING ODD FIRST
        // temp = head;
        // while (temp!=null && temp.next!=null){
        //     list.add(temp.val);
        //     temp=temp.next.next;
        // }
        // if (temp!=null) list.add(temp.val);
        // //NOW STORING EVEN
        // temp = head.next;
        // while (temp!=null && temp.next!=null){
        //     list.add(temp.val);
        //     temp=temp.next.next;
        // }
        // if (temp!=null) list.add(temp.val);
        // //REPOPULATING LINKED LIST
        // temp=head;
        // int i=0;
        // while(temp!=null){
        //     temp.val = list.get(i);
        //     i++;
        //     temp=temp.next;
        // }
        // return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next=evenHead;
        return head;
    }
}