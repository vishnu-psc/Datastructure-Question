class Solution 
{
    public int numSubarraysWithSum(int[] nums, int goal) 
    {
        int n = nums.length;
        int currentSum = 0, totalCount = 0;
        
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i =0 ; i < n; i++)
        {
            currentSum += nums[i];
            if(currentSum == goal) totalCount++;
            
            if(mp.containsKey(currentSum - goal))
            {
                totalCount += mp.get(currentSum - goal);
            }
            
            mp.put(currentSum, mp.getOrDefault(currentSum, 0) + 1);
        }
        
        
        
        return totalCount;
    }
}