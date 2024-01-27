class Solution 
{
    
    int mod = 1_000_000_007;
    
//     public int solve(int n, int k, int[][] dp)
//     {
//         if(n == 0) return 0;
//         if(k == 0) return 1;
        
//         if(dp[n][k] != -1) return dp[n][k];
//         int result = 0;
        
//         for(int inv = 0; inv <= Math.min(n-1,k); inv++)
//         {
//             result = (result + solve(n-1, k-inv, dp))%mod;
//         }
//         return dp[n][k] = result;
//     }
    public int kInversePairs(int n, int k) 
    {
        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i <= n; i++) dp[i][0] = 1;
        
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= k; j++)
            {
                for(int inv = 0; inv <= Math.min(i-1, j); inv++)
                {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-inv])%mod;
                }
            }
        }
        
        return dp[n][k];
    }
}