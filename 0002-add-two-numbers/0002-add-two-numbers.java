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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode l = new ListNode(0);
        ListNode temp = l;
        ListNode i = l1;
        ListNode j = l2;
        int carry = 0;
        while(i != null || j != null || carry == 1)
        {
            int sum = carry; 
            if(i != null)
            {
                sum += i.val;
                i = i.next;
            }
            if(j != null)
            {
                sum += j.val;
                j = j.next;
            }
            carry = sum/10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
        }
        
        return l.next;
    }
}