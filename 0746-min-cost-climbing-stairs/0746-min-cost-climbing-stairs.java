class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        int n = cost.length;
        return Math.min(solve(cost, n-1, dp), solve(cost, n-2, dp));    
    }
    
    public int solve(int[] cost, int n, int[] dp)
    {
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        int left = solve(cost, n-1, dp);
        int right = solve(cost, n-2, dp);
        return dp[n] = cost[n]+ Math.min(left, right);
    }
}