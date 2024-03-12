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
    public ListNode removeZeroSumSublists(ListNode head) 
    {
        int prefixSum = 0;
        Map<Integer, ListNode> mp = new HashMap<>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        
        mp.put(0, dummyNode);
        
        while(head != null)
        {
            prefixSum += head.val;
            
            if(mp.containsKey(prefixSum))
            {
                ListNode start = mp.get(prefixSum);
                ListNode temp = start;
                
                int pSum = prefixSum;
                
                while(temp != head)
                {
                    temp = temp.next;
                    pSum += temp.val;
                    
                    if(temp != head) mp.remove(pSum);
                }
                start.next = head.next;
            }
            else 
            {
                mp.put(prefixSum, head);
            }
            head = head.next;
        }
        
        return dummyNode.next;
    }
}