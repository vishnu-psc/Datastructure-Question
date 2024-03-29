class Solution 
{
    public long countSubarrays(int[] nums, int k) 
    {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++)
        {
            max = Math.max(max, nums[i]);    
        }
        
        int i = 0;
        int j = 0;
        long result = 0;
        int count = 0;
        
        while(j < n)
        {
            if(nums[j] == max) count++;
            
            while(count >= k)
            {
                result += n-j;
                if(nums[i] == max) count--;
                i++;
            }
            j++;
        }
        return result;
    }
}