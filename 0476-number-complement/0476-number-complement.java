class Solution 
{
    public int findComplement(int num) 
    {
        int i = 0, ans = 0;
        while(num != 0)
        {
            if((num&1) == 0)
            {
                ans += (int)Math.pow(2,i);
            }
            i++;
            num = num >> 1;
        }
        return ans;
    }
}