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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length;i++)
            inMap.put(inorder[i], i);
        
        TreeNode root = buildTree(inorder, 0, inorder.length - 1,
                                  postorder, 0 , postorder.length - 1, inMap);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder,
                              int ps, int pe, Map<Integer, Integer> inMap)
    {
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        
        int inRoot = inMap.get(postorder[pe]);
        int numsLeft = inRoot - is;
        
        root.left = buildTree(inorder, is, inRoot - 1,
                              postorder, ps, ps + numsLeft - 1, inMap);
        root.right = buildTree(inorder, inRoot + 1, ie,
                               postorder, ps + numsLeft , pe - 1, inMap);
        return root;
    }
}