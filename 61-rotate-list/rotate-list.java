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
    public int size(ListNode head){
        int size =0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null){
            return head;
        }
        int size = size(head);
        k = k%size;

        if(k == 0){
            return head;
        }
        // find tail
        ListNode tail = null;
        ListNode curr = head;
        while(curr != null){
            tail = curr;
            curr = curr.next;
        }

        ListNode tempHead = head;
        int i =0;
        ListNode prev = null;
        curr = head;
        while(i < size-k){
            prev = curr;
            curr = curr.next;
            i++;
        }
        head = curr;
        tail.next = tempHead;
        prev.next = null; 
        return head;
    }
}