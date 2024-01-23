class Solution 
{
    public boolean isUnique(String str)
    {
        Set<Character> s = new HashSet<>();
        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i); 
            if(s.contains(c)) return false;
            else s.add(c);
        }
        return true;
    }
    
    public int dfs(List<String> arr, int n, String res)
    {
        if(n < 0) return res.length();
        
        int take = 0, leave = 0;
        if(isUnique(res + arr.get(n)))
        {
            leave = dfs(arr, n-1, res);
            take = dfs(arr, n-1, res+arr.get(n));
        }
        else
            leave = dfs(arr, n-1, res);
        
        return Math.max(take, leave);
    }
    
    public int maxLength(List<String> arr) 
    {
        int n = arr.size();
        return dfs(arr, n-1, "");
    }
    
}