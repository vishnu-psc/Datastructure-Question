class Solution 
{
    public double champagneTower(int poured, int row, int glass) 
    {
        double[][] dp = new double[101][101];
        for(int i = 0; i < 101; i++)
        {
            for(int j = 0; j < 101; j++)
                dp[i][j] = -1.0;
        }
        return Math.min(1.0, solve(poured, row, glass, dp));     
    }
    
    public double solve(int poured, int i, int j, double[][] dp)
    {
        if(i < 0 || j < 0 || i < j) return 0.0;
        if(i == 0 && j == 0) return poured;    // top glass
        
        if(dp[i][j] != -1.0) return dp[i][j];
        
        double up_left = (solve(poured, i-1, j-1, dp) - 1)/ 2.0;
        double up_right = (solve(poured, i-1, j, dp) - 1) / 2.0;
        
        if(up_left < 0) up_left = 0.0;
        if(up_right < 0) up_right = 0.0;
        
        return dp[i][j] = up_left + up_right; 
    }
}