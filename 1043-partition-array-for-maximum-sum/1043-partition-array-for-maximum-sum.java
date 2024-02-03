class Solution 
{
    public int solve(int[] arr, int i, int k, int[] dp)
    {
        int n = arr.length;
        if(i >= n) return 0;
        if(dp[i] != 0) return dp[i];
        int curr_max = -1;
        int res = 0;
        for(int j = i; j < n && j-i+1 <= k; j++)
        {
            curr_max = Math.max(curr_max, arr[j]);
            res = Math.max(res, (j-i+1)*curr_max + solve(arr, j+1, k, dp));
        }
        return dp[i] = res;
    }
    
    public int maxSumAfterPartitioning(int[] arr, int k) 
    {
        int n = arr.length;
        int[] dp = new int[n];
        return solve(arr, 0, k, dp);
    }
}