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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }else if(head.next.next == null){
            head.next = null;
            return head;
        }else{
            ListNode prev = head;
            ListNode curr = prev.next;
            ListNode next = curr.next;
            
            while(next != null && next.next != null){
                next = next.next.next;
                prev = prev.next;
                curr = curr.next;
            }
            
            prev.next = curr.next;
            curr.next = null;
            
            return head;
        }
    }
}