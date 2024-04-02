class Solution 
{
    public boolean isIsomorphic(String s, String t) 
    {
        if(s.length() != t.length()) return false;
        Map<Character, Character> mp = new HashMap<>();
        Map<Character, Character> revmp = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            if(mp.containsKey(a))
            {
                if(mp.get(a) != b) return false;
            }
            
            if(revmp.containsKey(b))
            {
                if(revmp.get(b) != a) return false;
            }
            
            mp.put(a, b);
            revmp.put(b, a);
        }
        return true;
    }
}