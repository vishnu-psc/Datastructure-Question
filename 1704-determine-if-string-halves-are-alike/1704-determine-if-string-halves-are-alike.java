class Solution 
{
    public boolean solve(String s, int n)
    {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');vowel.add('e');vowel.add('i');vowel.add('o');vowel.add('u');
        vowel.add('A');vowel.add('E');vowel.add('I');vowel.add('O');vowel.add('U');
        
        int mid = n/2;
        int first = 0, second = 0;
        
        for(int i = 0; i < mid; i++)
        {
            char a = s.charAt(i);
            char b = s.charAt(mid+i);
            
            if(vowel.contains(a)) first++;
            if(vowel.contains(b)) second++;
        }
        
        return first == second;
        
    }
    
    public boolean halvesAreAlike(String s) 
    {
        return solve(s, s.length());
    }
    
}