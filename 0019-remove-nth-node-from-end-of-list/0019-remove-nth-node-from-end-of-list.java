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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode temp = head;
        int size = 0;
        while(temp != null)
        {
            size++;
            temp = temp.next;
        }
        
        temp = head;
        int remove = size - n - 1;
        
        if(remove == -1) return head.next;
        
        while(remove-- > 0)
        {
            temp = temp.next;
        }
        
        temp.next = temp.next.next;
        
        return head;
    }
}