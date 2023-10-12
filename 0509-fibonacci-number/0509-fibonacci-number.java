class Solution 
{
    public int fib(int n) 
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return f(n , dp);
    }
    
    public int f(int n, int[] dp)
    {
        if(n <= 1) return n;
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}