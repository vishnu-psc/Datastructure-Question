class Solution 
{
    public String customSortString(String order, String s) 
    {
        int[] occ = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            occ[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char i: order.toCharArray())
        {
            int m = occ[i -'a'];
            for(int j = 0; j < m; j++)
            {
                sb.append(i);
                occ[i -'a']--;
                
            }
        }
        for(int i = 0; i < s.length(); i++)
        {
            if(occ[s.charAt(i) - 'a'] > 0) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}