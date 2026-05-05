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
        if (head == null || head.next == null || k == 0) return head;
        
        int n = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            n++;
        }

        k = k%n;
        ListNode temphead1 = reverseLL(head, 1, n);
        System.out.println(temphead1.val);
        ListNode temphead2 = reverseLL(temphead1, 1, k);
        System.out.println(temphead2.val);
        ListNode temphead3 = reverseLL(temphead2, k+1, n);

        return temphead3;
    }

    public ListNode reverseLL(ListNode head, int left, int right){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
}

