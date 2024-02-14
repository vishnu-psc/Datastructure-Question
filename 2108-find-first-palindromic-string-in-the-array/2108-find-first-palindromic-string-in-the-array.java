class Solution {
    public boolean isPalindrome(String s)
    {
        int n = s.length();
        int i = 0, j = n-1;
        
        while(i <= j)
        {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
    
    
    public String firstPalindrome(String[] words) 
    {
        int n = words.length;
        String res = "";
        for(int i = 0; i < n; i++)
        {
            if(isPalindrome(words[i]))
            {
                res = words[i];
                break;
            }
        }
        return res;
    }
}