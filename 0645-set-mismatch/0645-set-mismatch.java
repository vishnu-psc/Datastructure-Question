class Solution 
{
    public int[] findErrorNums(int[] nums) 
    {
        int n = nums.length;
        int duplicate = 0, missing = 0;
        
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 1; i <= n; i++) m.put(i, 0);
        
        for(int i = 0; i < n; i++) m.put(nums[i], m.get(nums[i])-1);
        
        for(var i: m.entrySet())
        {
            if(i.getValue() == -2) duplicate = i.getKey();
            if(i.getValue() == 0) missing = i.getKey();
        }
        
        return new int[]{duplicate, missing};
        
    }
}