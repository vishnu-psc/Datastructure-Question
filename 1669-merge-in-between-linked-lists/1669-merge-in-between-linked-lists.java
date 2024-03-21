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
class Solution 
{
    public ListNode mergeInBetween(ListNode head, int a, int b, ListNode list2) 
    {
        ListNode temp1 = head;
        ListNode temp2 = head;
        b = b+1;
        while(--a > 0)
        {
            temp1 = temp1.next;
        }
        while(b-- > 0)
        {
            temp2 = temp2.next;
        }
        
        temp1.next = list2;
        
        while(temp1.next != null)
        {
            temp1 = temp1.next;
        }
        
       
        
        temp1.next = temp2;
        
        return head;
    }
}