class Solution 
{
    public String removeKdigits(String num, int k) 
    {
        Stack<Character> s = new Stack<>();
        int i = 0;
        
        while(i < num.length())
        {
            while(k > 0 && !s.isEmpty() && s.peek() > num.charAt(i))
            {
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
            i++;
        }
        
        while(k > 0 && !s.isEmpty())
        {
            s.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c: s)
        {
            sb.append(c);
        }
        
        while(sb.toString().startsWith("0")) sb.deleteCharAt(0);
        
        return sb.length() == 0 ? "0": sb.toString();
    }
}