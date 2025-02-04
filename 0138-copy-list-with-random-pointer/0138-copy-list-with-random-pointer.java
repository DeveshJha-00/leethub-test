/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head==null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node temp=head;
        while(temp!=null){
            Node val = new Node(temp.val);
            map.put(temp, val);
            temp=temp.next;
        }

        temp=head;
        //Node newHead = temp;
        while (temp!=null){
            Node copiedNode = map.get(temp);
            copiedNode.next = map.get(temp.next);
            copiedNode.random = map.get(temp.random);
            temp=temp.next;
        }

    //KEEPING TRACK OF NEWHEAD AND RETURNING IT HERE WONT WORK SINCE ONLY REFERENCE WILL BE RETURNED
        return map.get(head);
    }
}