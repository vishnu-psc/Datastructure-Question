class Solution 
{
    int mod = 1_000_000_007;
//     public int solve(int m, int n, int max, int i, int j, int[][][] dp)
//     {
//         if(max < 0) return 0;
//         if(i >= m || j >= n || i < 0 || j < 0) 
//         {
//             return 1;
//         }
 
//         if(dp[i][j][max] != -1) return dp[i][j][max];
        
//         int ans = 0;        
//         int[] x = {-1, 0, 0, +1};
//         int[] y = {0, +1, -1, 0};
        
        
//         for(int k = 0; k < 4; k++)
//         {
//         ans = (ans + solve(m, n, max -1, i + x[k], j + y[k], dp)) % mod;
//         }
        
//         return dp[i][j][max] = ans;
//     }
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) 
    {
        int[][][] dp = new int[51][51][51];
        int[] x = {-1, 0, 0, +1};
        int[] y = {0, +1, -1, 0};
        for(int k = 1; k <= maxMove; k++)
        {   
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j< n; j++)
                {
                    for(int l = 0; l < 4; l++)
                    {
                        int xdir = i + x[l];
                        int ydir = j + y[l];
                        if(xdir >= m || ydir >= n || xdir < 0 || ydir < 0)
                            dp[i][j][k] = (1 + dp[i][j][k]) % mod;
                        else
                            dp[i][j][k] =  (dp[i][j][k] + dp[xdir][ydir][k-1])%mod;
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}