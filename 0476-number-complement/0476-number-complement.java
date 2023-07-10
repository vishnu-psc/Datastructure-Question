class Solution 
{
    public int findComplement(int num) 
    {
        int bit = (int)Math.floor(Math.log(num)/Math.log(2))+1;
        int bitMask = (1 << bit) - 1;
        return bitMask ^ num;
    }
}