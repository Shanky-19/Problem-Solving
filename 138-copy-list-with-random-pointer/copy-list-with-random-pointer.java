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
        HashMap<Node,Node> hm = new HashMap<>();
        Node temp1 = head;
        Node newHead = null;
        Node newTail = null;
        while(temp1 != null){
            Node newNode = new Node(temp1.val);
            if(newHead == null){
                newHead = newNode;
                newTail = newHead;
            }else{
                newTail.next = newNode;
                newTail = newTail.next;
            }
            hm.put(temp1,newNode);
            temp1 = temp1.next;
        }

        Node tempTail = newHead;
        temp1=head;
        while(temp1 != null){
            Node random = temp1.random;
            if(random == null){
                tempTail.random =null;
            }else{
                if(hm.containsKey(random)){
                    Node newRandom = hm.get(random);
                    tempTail.random = newRandom;
                }
            }
            temp1 = temp1.next;
            tempTail = tempTail.next;
        }
        return newHead;
    }
}