class Solution 
{
    public int minFallingPathSum(int[][] matrix) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[m][n];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int col = 0; col < m; col++)
        {
            min = Math.min(min, dfs(matrix, 0, col, dp));
        }
        return min;
    }
    
    public int dfs(int[][] matrix, int row, int col, int[][] dp)
    {
        if(col < 0 || col >= matrix[0].length) return 101*100;
        
        if(row == matrix.length-1) return matrix[row][col];
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
        
        int u = matrix[row][col] + dfs(matrix, row+1, col, dp);
        int ld = matrix[row][col] + dfs(matrix, row+1, col-1, dp);
        int rd = matrix[row][col] + dfs(matrix, row+1, col+1, dp);
        
        return dp[row][col] = Math.min(u, Math.min(ld, rd));
    }
}