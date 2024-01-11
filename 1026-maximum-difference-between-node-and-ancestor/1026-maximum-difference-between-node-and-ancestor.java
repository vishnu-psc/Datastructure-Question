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
    public int maxAncestorDiff(TreeNode root) 
    {
        int min = root.val, max = root.val;
        return dfs(root, min, max);
    }
    
    public int dfs(TreeNode root, int min, int max)
    {
        if(root == null) return max-min;
        
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        
        int left = dfs(root.left, min,max);
        int right = dfs(root.right, min, max);
        
        return Math.max(left,right);
        
    }
    
}