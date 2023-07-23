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
    private List<TreeNode> solve(int n, List<List<TreeNode>> dp)
    {
        if(n%2 == 0) return new ArrayList<TreeNode>();
        
        dp.get(1).add(new TreeNode(0, null, null));
        
        for(int i = 3; i <= n; i += 2)
        {
            for(int j = 1; j < i - 1; j += 2)
            {  
                for(TreeNode l: dp.get(j))
                {
                    for(TreeNode r: dp.get(i-j-1))
                    {
                        TreeNode root = new TreeNode(0, l, r);
                        dp.get(i).add(root);
                    }
                }
            }
        }
        return dp.get(n);
            
    }
    
    public List<TreeNode> allPossibleFBT(int n) 
    {
        List<List<TreeNode>> dp = new ArrayList<>();
        for(int i = 0; i <= n; i++)
        {
            dp.add(new ArrayList<>());
        }
        return solve(n, dp);
    }
}