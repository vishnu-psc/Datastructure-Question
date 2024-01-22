class Solution 
{
    public int[] findErrorNums(int[] nums) 
    {
        int n = nums.length;
        int[] res = new int[2];
        
        int[] freq = new int[n+1];
        
        for(int i = 0; i < n; i++) freq[nums[i]]++;
        
        for(int i = 0; i <= n; i++)
        {
            if(freq[i] == 2) res[0] = i;
            if(freq[i] == 0) res[1] = i;
        }
        
        return res;
        
    }
}