class Solution {
    public int[] productExceptSelf(int[] nums)
    {
        int n = nums.length, temp = 1;    
        int[] output = new int[n];
        for(int i = 0; i < n; i++)
        {
            output[i] = temp;
            temp = temp*nums[i];
        }
        temp = 1;
        for(int i = n -1; i >= 0; i--)
        {
            output[i] = temp*output[i];
            temp = temp*nums[i];
        }
        return output;
    }
}