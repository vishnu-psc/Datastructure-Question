class Solution 
{
    public boolean check(String s, int i, int j, int[][] dp)
    {
        if(i >= j) return true;
        if(dp[i][j] != -1) return dp[i][j] == 1;
        if(s.charAt(i) == s.charAt(j))   
        {
            boolean val = check(s, i+1, j-1, dp);
            if(val) dp[i][j] = 1;
            else dp[i][j] = 0;
            return val;
        }
        dp[i][j] = 0;
        return false;
        
    }
    public int countSubstrings(String s) 
    {
        int n = s.length();
        int count = 0;
        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                if(check(s, i, j, dp)) count++;
            }
        }
        return count;
    }
}