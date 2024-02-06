class Solution 
{   public boolean areAnagram(String s, String t)
    {
        if(s.equals("A") || t.equals("A")) return false;
        if(s.length() != t.length()) return false;
        int n = s.length();
        int[] arr = new int[26];
        for(int i = 0; i < n; i++)
        {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26; i++)
        {
            if(arr[i] != 0) return false;
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> res = new ArrayList<>();
        int n = strs.length;
        for(int i = 0; i < n ; i++)
        {
            List<String> l = new ArrayList<>();
            if(!strs[i].equals("A")) l.add(strs[i]);
            for(int j = i + 1; j < n; j++)
            {
                if(areAnagram(strs[i], strs[j]))
                {
                    l.add(strs[j]);
                    strs[j] = "A";
                }
            }
            if(!l.isEmpty()) res.add(l);
        }
        return res;
    }
}