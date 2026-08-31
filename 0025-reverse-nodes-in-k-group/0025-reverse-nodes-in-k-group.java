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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {
            ListNode kThNode = getKthNode(temp, k);

            if (kThNode == null){ //not a complete group
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            ListNode nextNode = kThNode.next;
            kThNode.next = null;

            reverseLinkedList(temp);

            if (temp == head) {
                head = kThNode;
            } else {
                prevLast.next = kThNode;
            }

            prevLast = temp;
            temp = nextNode;

        }

        return head;
    }

    public ListNode getKthNode(ListNode temp, int k) {
        k -= 1;

        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }

        return temp;
    }

    public void reverseLinkedList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        // return prev;
    }
}