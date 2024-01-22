class Solution 
{
    public int[] findErrorNums(int[] nums) 
    {
        int n = nums.length;
        int[] res = new int[2];
        
        for(int i = 1; i <= n; i++)
        {
            int count = 0;
            for(int j = 0; j < n; j++)
            {
                if(nums[j] == i) count++;    
            }
            if(count == 2) res[0] = i;
            if(count == 0) res[1] = i;
        }
        
        return res;
        
    }
}