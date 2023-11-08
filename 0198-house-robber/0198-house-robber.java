// Memo
class Solution 
{
    public int rob(int[] nums) 
    {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, n, dp);
    }
    
    public int solve(int[] nums, int n, int[] dp)
    {
        dp[0] = nums[0];
        for(int i = 1; i < n; i++)
        {
            int take = nums[i];
            if(i > 1) take += dp[i-2];
            int nottake = dp[i-1];
            dp[i] = Math.max(take, nottake);
        }
        
        return dp[n-1];
    }
}