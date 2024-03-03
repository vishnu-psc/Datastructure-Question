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
        Stack<ListNode> st = new Stack<>();
        
        while(temp != null)
        {
            st.push(temp);
            temp = temp.next;
        }
        
        while(n-- > 0) st.pop();
        
        if(st.isEmpty()) return head.next;
        
        ListNode node = st.pop();
        
        node.next = node.next.next;
        
        return head;
    }
}