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
        int prev = nums[0];
        int prev2 = 0, curr = 0;
        
        for(int i = 1; i < n; i++)
        {
            int take = nums[i];
            if(i > 1) take += prev2;
            int nottake = prev;
            curr = Math.max(take, nottake);
            prev2 = prev;
            prev = curr;
            
        }
        
        return prev;
    }
}