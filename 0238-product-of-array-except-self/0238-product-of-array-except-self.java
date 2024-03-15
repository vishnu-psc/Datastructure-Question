class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int n = nums.length;
        int[] prefix = new int[n];
        
        int temp = 1;
        
        for(int i = 0; i < n; i++)
        {
            prefix[i] = temp;
            temp = temp*nums[i];
        }
        temp = 1;
        
        for(int i = n-1; i >= 0; i--)
        {
            prefix[i] = temp*prefix[i];
            temp = temp*nums[i];
        }
        return prefix;
    }
}