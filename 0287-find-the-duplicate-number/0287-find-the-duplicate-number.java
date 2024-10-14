class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        int ans = -1;
        for(int i = 0; i < nums.length; i++)
        {
            if(vis[nums[i]] == false) vis[nums[i]] = true;
            else
            {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
}