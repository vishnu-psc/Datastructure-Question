/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public boolean isEvenOddTree(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean even = true;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            int prev = Integer.MAX_VALUE;
            if(even) prev = Integer.MIN_VALUE;
            
            while(size-- > 0)
            {
                TreeNode temp = q.poll();
                int value = temp.val;
                if((!even && (value % 2 == 1 || prev <= value)) || 
                    (even && (value % 2 == 0 || prev >= value))) return false;
                
                prev = value;
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            even = !even;
        }
        
        return true;
        
    }
}