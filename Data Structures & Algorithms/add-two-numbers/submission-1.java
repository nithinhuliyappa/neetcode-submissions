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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        //Pointer to the head of the res list 
        ListNode dummyHead = new ListNode(0);
        //pointer to iterate the list
        ListNode curr = dummyHead;

        while(l1 != null || l2 != null || carry != 0){
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;

            int sum = carry + num1 + num2;
            int digit = sum % 10;
            carry = sum / 10;

            curr.next = new ListNode(digit);
            curr = curr.next;

            l1 = l1!= null ? l1.next : null;
            l2 = l2!= null ? l2.next : null;
        }
        
        return dummyHead.next;
    }
}
