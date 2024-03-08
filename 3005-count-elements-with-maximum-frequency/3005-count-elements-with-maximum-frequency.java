class Solution 
{
    public int maxFrequencyElements(int[] nums) 
    {
        int[] freq = new int[101];
        for(int i = 0; i < nums.length; i++)
        {
            freq[nums[i]]++;
        }
        
        int count = 0, res = 0;
        
        for(int i = 1; i < 101; i++)
        {
            count = Math.max(count, freq[i]);
        }
        for(int i = 0; i < 101; i++)
        {
            if(freq[i] == count) res += count;
        }
        return res;
    }
}