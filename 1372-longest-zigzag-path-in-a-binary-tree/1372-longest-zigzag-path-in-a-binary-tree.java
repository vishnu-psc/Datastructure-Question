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
    int maxLength = 0;
    public int longestZigZag(TreeNode root) 
    {
        solve(root, false, 0);
        solve(root, true, 0);
        return maxLength;
    }
    private void solve(TreeNode root, boolean isLeft, int  currentLength)
    {
        if(root == null) return;
        maxLength = Math.max(maxLength, currentLength);
        if(isLeft)
        {
            solve(root.left, false, currentLength + 1);
            solve(root.right, true, 1);
        }
        else
        {
            solve(root.left, false, 1);
            solve(root.right, true, currentLength + 1);
        }
    }
}