class Solution 
{
    public long largestPerimeter(int[] nums) 
    {
        int n = nums.length;
        Arrays.sort(nums);
        
        long previousElementSum = 0;
        long ans = -1;
        
        for(int i = 0; i < n; i++)
        {
            if(i >= 2 && nums[i] < previousElementSum)
            {
                ans = nums[i] + previousElementSum;
            }
            previousElementSum += nums[i];
        }
        return ans;
    }
}