class Solution 
{
    public int[] findErrorNums(int[] nums) 
    {
        int n = nums.length;
        int[] res = new int[2];
        int nsum = (n*(n+1))/2;
        int asum = 0;
        int usum = 0;
        var s = new HashSet<Integer>();
        
        for(int i = 0; i < n; i++) s.add(nums[i]);
        for(int i: s) usum += i;
        for(int i: nums) asum += i;
        
        res[0] = asum - usum;
        res[1] = nsum - usum;
        
        return res;
        
    }
}