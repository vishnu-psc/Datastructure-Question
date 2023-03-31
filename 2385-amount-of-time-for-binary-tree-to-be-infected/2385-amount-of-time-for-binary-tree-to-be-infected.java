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
    private int findMaximumTime(Map<TreeNode, TreeNode> map, TreeNode source)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(source);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(source, true);
        int time = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            boolean flag = false;
            for(int i = 0; i < size; i++)
            {
                TreeNode current = q.poll();
                if(current.left != null && visited.get(current.left) == null)
                {
                    flag = true;
                    visited.put(current.left, true);
                    q.offer(current.left);
                }
                if(current.right != null && visited.get(current.right) == null)
                {
                    flag = true;
                    visited.put(current.right, true);
                    q.offer(current.right);
                }
                if(map.get(current) != null && visited.get(map.get(current)) == null)
                {
                    flag = true;
                    visited.put(map.get(current), true);
                    q.offer(map.get(current));
                }
            }
            if(flag) time++; 
        }
        return time;
    }
    
    private TreeNode markParents(TreeNode root, Map<TreeNode, TreeNode> parents_track, int start)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode source = new TreeNode(-1);
        while(!q.isEmpty())
        {
            TreeNode current = q.poll();
            if(current.val == start) source = current;
            if(current.left != null)
            {
                parents_track.put(current.left, current);
                q.offer(current.left);
            }
            if(current.right != null)
            {
                parents_track.put(current.right, current);
                q.offer(current.right);
            }
        }
        return source;
    }
   
    public int amountOfTime(TreeNode root, int start) 
    {
        Map<TreeNode, TreeNode> parents_track = new HashMap<>();
        TreeNode source = markParents(root, parents_track, start); 
        return findMaximumTime(parents_track, source);
        
    }
}