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
    public int countNodes(TreeNode root) 
    {
        if(root == null) return 0;
        
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        
        if(lh == rh) return ((int)Math.pow(2,lh) - 1);
        
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int getLeftHeight(TreeNode current)
    {
        int ht = 0;
        while(current != null)
        {
            ht++;
            current = current.left;
        }
        return ht;
    }
    
    private int getRightHeight(TreeNode current)
    {
        int ht = 0;
        while(current != null)
        {
            ht++;
            current = current.right;
        }
        return ht;
    }
}