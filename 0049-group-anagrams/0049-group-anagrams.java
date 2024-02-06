class Solution 
{
    public String sort(String s)
    {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        int n = strs.length;
        List<List<String>> result = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++)
        {
            String temp = strs[i];
            
            String sortedStr = sort(temp);
            
            map.put(sortedStr, map.getOrDefault(sortedStr, new ArrayList<>()));
            map.get(sortedStr).add(strs[i]);
        }
        //System.out.println(map);
        for(Map.Entry<String, List<String>> i: map.entrySet())
        {
            result.add(i.getValue());
        }
        return result;
    }
}