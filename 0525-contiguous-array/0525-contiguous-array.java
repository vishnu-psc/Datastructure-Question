class Solution 
{
    public int findMaxLength(int[] nums) 
    {
        int n = nums.length;
        int currSum = 0;
        int maxLen = 0;
        int len = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int index = 0; index < n; index++)
        {
            if(nums[index] == 1) currSum += 1;
            else currSum -= 1;
            
            if(map.containsKey(currSum)) len = index - map.get(currSum);
            else map.put(currSum, index);
            
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}