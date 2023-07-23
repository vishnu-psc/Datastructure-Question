class Solution
{
    double[][][] dp;
    int[] delx = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] dely = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public double solve(int row, int col, int k, int n)
    {
        if(row < 0 || row >= n || col < 0 || col >= n)
            return 0;
        if(k == 0) return 1;
        if(dp[row][col][k] != -1.0) return dp[row][col][k];
        
        double ans = 0;
        for(int i = 0; i < 8; i++)
        {
            ans += solve(row + delx[i], col + dely[i], k-1, n);
        }
        
        return dp[row][col][k] = ans;
    }
    
    public double knightProbability(int n, int k, int row, int column) 
    {
        dp = new double[n][n][k+1];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                Arrays.fill(dp[i][j], -1);
            }
        }
        double favor = solve(row, column, k, n);
        double tot = Math.pow(8,k);
        return favor/tot;
    }
}