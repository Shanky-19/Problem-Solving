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
import java.util.*;
class Solution {

    private int getSize (ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public int pairSum(ListNode head) {
        int n = getSize(head);
        LinkedList<Integer> stack = new LinkedList<>();
        int idx = 0;
        ListNode temp = head;
        while(idx <= (n/2)-1) {
            stack.addFirst(temp.val);
            temp = temp.next;
            idx++;
        }

        int maxSum = Integer.MIN_VALUE;
        while (temp != null) {
            int val1 = temp.val;
            int val2 = stack.removeFirst();

            maxSum = Math.max(maxSum, val1 + val2);
            temp = temp.next;
        }
        return maxSum;
    }
}