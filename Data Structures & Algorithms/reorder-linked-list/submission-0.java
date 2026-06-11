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
    public void reorderList(ListNode head) {

        //Step1 : Find the Mid

        ListNode slow = head;
        ListNode fast = head;
        ListNode firstL = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the right half 
        ListNode secondL = reverse(slow.next);
        //partition
        slow.next = null;

        //reorder
        while(secondL!=null){
            ListNode next = firstL.next;
            ListNode sNext = secondL.next;

            firstL.next = secondL;      
            secondL.next = next;

            firstL = next;
            secondL = sNext;
        }
        
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
