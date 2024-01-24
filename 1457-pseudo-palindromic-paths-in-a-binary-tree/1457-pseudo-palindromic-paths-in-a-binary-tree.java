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
    public boolean checkPalindrome(int[] arr)
    {
        int oddOcc = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i]%2 == 1) oddOcc++;
        }
        
        if(oddOcc <= 1) return true;
        return false;
    }
    
    public void back(TreeNode root, int[] arr, int[] result)
    {
        if(root != null)
        {
            arr[root.val]++;
            
            if(root.left == null && root.right == null)
            {
                if(checkPalindrome(arr))
                    result[0]++;
            }
            back(root.left, arr, result);
            back(root.right, arr, result);
            arr[root.val]--;
        }
    }
    
    public int pseudoPalindromicPaths (TreeNode root) 
    {
        int[] arr = new int[10];
        int[] result = {0};
        back(root, arr, result);   
        return result[0];
    }
}