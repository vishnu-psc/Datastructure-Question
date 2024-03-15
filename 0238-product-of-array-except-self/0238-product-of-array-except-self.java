class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        int pr = 1, su = 1;
        
        for(int i = 0; i < n; i++)
        {
            prefix[i] = pr;
            pr = pr*nums[i];
            
        }
        
        for(int i = n-1; i >= 0; i--)
        {
            suffix[i] = su;
            su = su*nums[i];
        }
        
        for(int i = 0; i < n; i++)
        {
            prefix[i] = prefix[i]*suffix[i];
        }
        return prefix;
    }
}