class Solution {
    public boolean uniqueOccurrences(int[] arr) 
    {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i])+1);
            }
            else
            {
                map.put(arr[i], 1);
            }
        }
        
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        
        for(Map.Entry<Integer, Integer> i: map.entrySet())
        {
            a.add(i.getKey());
            b.add(i.getValue());
        }
        return a.size() == b.size();
    }
}