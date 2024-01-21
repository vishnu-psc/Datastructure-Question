class Solution 
{
    public boolean isPalindrome(String s)
    {
        int n = s.length();
        if(n <= 1) return true;
        int l = 0, r = s.length() - 1;
        
        while(l < r)
        {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;r--;
        }
        
        return true;
        
    }
    
    public String longestPalindrome(String s) 
    {
        int n = s.length();
        if(n <= 1) return s;
        
        int maxlen = 0;
        String res = "";
        
        for(int i = 0 ; i < n; i++)
        {
            for(int j = i; j <= n; j++)
            {
                String substr = s.substring(i,j);
                if(isPalindrome(substr)) 
                {
                    if(substr.length() > maxlen)
                    {
                        maxlen = substr.length();
                        res = substr;
                    }
                }
            }
        }
        return res;
    }
}