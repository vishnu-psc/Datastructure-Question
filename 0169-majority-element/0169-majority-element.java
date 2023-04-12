class Solution 
{
    public int majorityElement(int[] nums) 
    {
        int majority = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++)
        {
            count += nums[i] == nums[majority] ? 1:-1;
            if(count == 0)
            {
                i++;
                majority = i;
                count++;
            }
        }
        return nums[majority];
    }
}