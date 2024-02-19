class Solution 
{
    public boolean isPowerOfTwo(int n) 
    {
        int count = 0; 
        if(n < 0) return false;
        while(n != 0)
        {
            if((n&1) == 1) count++;
            n = n >> 1;
        }
        if(count == 1) return true;
        return false;
    }
}