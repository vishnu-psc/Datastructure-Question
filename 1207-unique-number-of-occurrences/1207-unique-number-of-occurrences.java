class Solution 
{
    public boolean uniqueOccurrences(int[] arr) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
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
        
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> i: map.entrySet())
        {
            if(!set.add(i.getValue())) return false;
        }
        return true;
    }
}