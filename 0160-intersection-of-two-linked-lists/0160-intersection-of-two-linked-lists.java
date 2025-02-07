/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        if (headA==headB) return headA;

        ListNode t1=headA, t2=headB;
        while (t1!=t2){
            t1=t1.next;
            t2=t2.next;
            if (t1==t2) return t1;
            if (t1==null) t1=headB;
            if (t2==null) t2=headA;
        }
        return t1;
    }

    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     int ct1=0, ct2=0;
    //     ListNode temp1=headA, temp2=headB;
    //     while(temp1!=null){
    //         ct1++;
    //         temp1=temp1.next;
    //     }
    //     while(temp2!=null){
    //         ct2++;
    //         temp2=temp2.next;
    //     }
    //     if (ct1>ct2){
    //         return collisionPoint(headB, headA, ct1-ct2);
    //     }else{
    //         return collisionPoint(headA, headB, ct2-ct1);
    //     }
    // }
    // public static ListNode collisionPoint(ListNode smaller, ListNode larger, int diff){
    //     while(diff!=0){
    //         diff--;
    //         larger=larger.next;
    //     }
    //     while(smaller!=larger){
    //         smaller=smaller.next;
    //         larger=larger.next;
    //     }
    //     return smaller;
    // }

    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     HashMap<ListNode, Integer> map = new HashMap<>();
    //     ListNode temp1 = headA;
    //     while (temp1 != null){
    //         map.put(temp1, 1);
    //         temp1=temp1.next;
    //     }
    //     ListNode temp2=headB;
    //     while (temp2 != null){
    //         if (map.containsKey(temp2)) return temp2;
    //         temp2=temp2.next;
    //     }
    //     return null;
    // }

}