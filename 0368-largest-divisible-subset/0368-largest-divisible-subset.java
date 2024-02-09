class Solution 
{   
    
    
    public List<Integer> largestDivisibleSubset(int[] nums) 
    {
        int n = nums.length;
        Arrays.sort(nums);
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        
        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx, -1);
        
        int lastChosenIndex = 0;
        int maxL = 1;
        
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i]%nums[j] == 0)
                {
                    if(dp[i] < dp[j] + 1)
                    {
                        dp[i] = dp[j] + 1;
                        prevIdx[i] = j;
                    }
                    if(dp[i] > maxL)
                    {
                        maxL = dp[i];
                        lastChosenIndex = i;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(lastChosenIndex != -1)
        {
            result.add(nums[lastChosenIndex]);
            lastChosenIndex = prevIdx[lastChosenIndex];
        }
        return result;
    }
}