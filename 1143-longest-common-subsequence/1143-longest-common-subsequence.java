//Recursion
class Solution 
{
    public int r(String s1, String s2, int n, int m, int[][] dp)
    {
        if(n < 0 || m < 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(s1.charAt(n) == s2.charAt(m)) return 1 + r(s1, s2, n-1, m-1, dp);
        
        return dp[n][m] = Math.max(r(s1, s2, n-1, m, dp), r(s1, s2, n, m-1,dp));
        
    }
    
    public int longestCommonSubsequence(String s1, String s2) 
    {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n ; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return r(s1, s2, n-1, m-1, dp);   
    }
}