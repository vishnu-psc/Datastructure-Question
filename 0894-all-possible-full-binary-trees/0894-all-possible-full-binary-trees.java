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
    private List<TreeNode> solve(int n)
    {
        if(n%2 == 0) return new ArrayList<TreeNode>();
        if(n == 1) 
        {
            List<TreeNode> sn = new ArrayList<>();
            sn.add(new TreeNode(0, null, null));
            return sn;
        }
        
        List<TreeNode> result = new ArrayList<>();
        
        for(int i = 1; i < n; i += 2)
        {
            List<TreeNode> leftFBT = solve(i);
            List<TreeNode> rightFBT = solve(n-i-1);
            
            for(TreeNode l: leftFBT)
            {
                for(TreeNode r: rightFBT)
                {
                    TreeNode root = new TreeNode(0, l, r);
                    result.add(root);
                }
            }
        }
        return result;
            
    }
    
    public List<TreeNode> allPossibleFBT(int n) 
    {
        return solve(n);
    }
}