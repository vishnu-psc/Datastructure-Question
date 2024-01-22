class Solution 
{
    public boolean checkBit(int n, int i)
    {
        return ((n>>i) & 1) == 1;
    }
    
    public int[] findErrorNums(int[] nums) 
    {
        int n = nums.length;
        int duplicate = 0, missing = 0;
        int xor = 0;
        for(int i = 0; i < n; i++) xor = xor ^ nums[i] ^ (i+1);
        
        int bitPos = 0;
        for(int i = 0; i < 32; i++) 
        {
            if(checkBit(xor, i))
            {
                bitPos = i;
                break;
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            if(checkBit(nums[i], bitPos)) duplicate ^= nums[i];
            else missing ^= nums[i];
            
            if(checkBit((i+1), bitPos)) duplicate ^= (i+1);
            else missing ^= (i+1);
        }
        
        for(int i = 0; i < n; i++)
        {
            if(nums[i] == missing) 
            {
                int temp = duplicate;
                duplicate = missing;
                missing = temp;
                break;
            }
        }
        
        return new int[]{duplicate, missing};
        
    }
}