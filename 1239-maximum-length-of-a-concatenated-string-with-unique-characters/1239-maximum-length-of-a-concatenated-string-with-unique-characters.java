class Solution 
{
    public int setBit(int n)
    {
        int count = 0;
        for(int i = 0; i < 32; ++i)
        {
            if((n & 1) == 1) count++;
            n = n>>1;
        }
        return count;
    }
    
    public void solve(int idx, int temp, int[] result,  List<Integer> l)
    { 
        result[0] = Math.max(result[0], setBit(temp));
        for(int i = idx; i < l.size(); i++)
        {
            if((temp & l.get(i)) == 0) solve(i+1, (temp | l.get(i)), result, l);
        }
    }
    
    public int maxLength(List<String> arr) 
    {
        List<Integer> unqSub = new ArrayList<>();
        
        for(String s: arr)
        {
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < s.length(); i++) set.add(s.charAt(i));
            
            if(set.size() != s.length()) continue;
            
            int val = 0;
            
            for(char ch: set)
            {
                val = val | 1 << ((ch - 'a') ); 
            }
            
            unqSub.add(val);
        }
        int temp = 0;
        int[] result = {0};
        solve(0, temp, result, unqSub);
        return result[0];
    }
}