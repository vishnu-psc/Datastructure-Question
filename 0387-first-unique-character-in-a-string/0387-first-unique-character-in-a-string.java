class Solution 
{
    public int firstUniqChar(String s) 
    {
        int index = Integer.MAX_VALUE;
        for(char ch = 'a'; ch <= 'z'; ch++)
        {
            int c = s.indexOf(ch);
            if(c != -1 && c == s.lastIndexOf(ch))
            {
                index = Math.min(index, c);
            }
        }
        return index == Integer.MAX_VALUE ? -1: index;
    }
}