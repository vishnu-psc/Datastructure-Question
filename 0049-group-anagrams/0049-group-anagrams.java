class Solution 
{
    public String generate(String s)
    {
        int n = s.length();
        int[] arr = new int[26];
        String res ="";
        for(int i = 0; i < n; i++)
        {
            arr[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++)
        {
            if(arr[i] > 0)
            {
                String temp = "" + (char)('a' + i);
                res += temp.repeat(arr[i]);
                 
            }
        }
        return res;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        
        List<List<String>> result = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            String word = strs[i];
            String temp = generate(word);
            
            map.put(temp, map.getOrDefault(temp, new ArrayList<>()));
            map.get(temp).add(word);
        }
        
        for(Map.Entry<String, List<String>> i: map.entrySet())
        {
            result.add(i.getValue());
        }
        
        return result;
    }
}