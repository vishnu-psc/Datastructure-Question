class Solution 
{
    public int firstUniqChar(String s) 
    {
        int n = s.length();
        int[] occ = new int[26];
        for(int i = 0; i < n; i++)
        {
            occ[s.charAt(i) - 'a']++;
        }
        
        int index = -1;
        for(int i = 0; i < n; i++)
        {
            if(occ[s.charAt(i) - 'a'] == 1) 
            {
                index = i;
                break;
            }
        }
        return index;
    }
}