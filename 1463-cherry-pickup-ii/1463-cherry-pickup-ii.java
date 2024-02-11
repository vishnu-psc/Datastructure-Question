class Solution 
{
    
    public int solve(int[][] grid, int row, int c1, int c2, int[][][] dp)
    {
        int m = grid.length;
        int n = grid[0].length;
        
        if(row >= m) return 0;
        if(dp[row][c1][c2] != -1) return dp[row][c1][c2];
        
        int cherry = grid[row][c1];
        if(c1 != c2) cherry += grid[row][c2];
        int ans = 0;
        
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                int newRow = row+1;
                int newC1 = c1 + i;
                int newC2 = c2 + j;
                
                if(newC1 >= 0 && newC1 < n && newC2 >= 0 && newC2 < n)
                    ans = Math.max(ans, solve(grid, newRow, newC1, newC2, dp));
            }
        }
        return dp[row][c1][c2] = ans + cherry;
        
    }
    
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(grid, 0, 0, n-1, dp);
    }
}