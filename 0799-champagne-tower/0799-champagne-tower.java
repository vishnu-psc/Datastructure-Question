class Solution 
{
    public double champagneTower(int poured, int row, int glass) 
    {
        double[][] dp = new double[101][101];
        // for(int i = 0; i < 101; i++)
        // {
        //     for(int j = 0; j < 101; j++)
        //         dp[i][j] = -1.0;
        // }
        return Math.min(1.0, solve2(poured, row, glass, dp));     
    }
    
//     public double solve(int poured, int i, int j, double[][] dp)
//     {
//         if(i < 0 || j < 0 || i < j) return 0.0;
//         if(i == 0 && j == 0) return poured;    // top glass
        
//         if(dp[i][j] != -1.0) return dp[i][j];
        
//         double up_left = (solve(poured, i-1, j-1, dp) - 1)/ 2.0;
//         double up_right = (solve(poured, i-1, j, dp) - 1) / 2.0;
        
//         if(up_left < 0) up_left = 0.0;
//         if(up_right < 0) up_right = 0.0;
        
//         return dp[i][j] = up_left + up_right; 
//     }
    
    public double solve2(int poured, int k, int l, double[][] dp)
    {
        dp[0][0] = poured;
        for(int i = 0; i < dp.length-1; i++)
        {
            for(int j = 0; j < dp[0].length-1; j++)
            {
                double extra = (dp[i][j] - 1)/2;
                if(extra > 0)
                {
                    dp[i+1][j] += extra;
                    dp[i+1][j+1] += extra;
                }
            }
        }
        return dp[k][l];
    }
}