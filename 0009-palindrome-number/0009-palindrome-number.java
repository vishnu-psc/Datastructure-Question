class Solution 
{
    public boolean isPalindrome(int x) 
    {
        if(x < 0) return false;
        int n = x;
        int reverse = 0;
        while(n != 0)
        {
            int remainder = n%10;
            reverse = reverse*10 + remainder;
            n /= 10;
        }
        System.out.println(reverse);
        
        return x == reverse;
        
    }
}