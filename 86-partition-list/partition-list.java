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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        
        LinkedList<ListNode> queueLessThanX = new LinkedList<>();
        LinkedList<ListNode> queueMoreThanX = new LinkedList<>();
        
        // queue -> linkedlist -> removeFirst() and addLast() -> O(1)
        
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                ListNode t = new ListNode(temp.val);
                queueLessThanX.addLast(t);
            }else{
                ListNode t = new ListNode(temp.val);
                queueMoreThanX.addLast(t);
            }
            temp = temp.next;
        }
        head = null;
        if(queueLessThanX.size() > 0){
            head = queueLessThanX.removeFirst();
        }else if(queueMoreThanX.size() > 0){
            head = queueMoreThanX.removeFirst();
        }
        
        ListNode tail = head;
        while(queueLessThanX.size() > 0){
            ListNode t = queueLessThanX.removeFirst();
            tail.next = t;
            tail = tail.next;
        }
        
        while(queueMoreThanX.size() > 0){
            ListNode t = queueMoreThanX.removeFirst();
            tail.next = t;
            tail = tail.next; 
        }
        
        return head;
    }
}