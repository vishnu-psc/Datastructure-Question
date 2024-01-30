class Solution {
    public int evalRPN(String[] tokens) 
    {
        
        Stack<Integer> s = new Stack<>();   
        for(String i : tokens)
        {
            if(i.equals("+"))
                s.push(s.pop()+s.pop());
            else if(i.equals("-"))
            {
                int a = s.pop();
                int b = s.pop();
                s.push(b-a);
            }
            else if(i.equals("*"))
                s.push(s.pop()*s.pop());
            else if(i.equals("/"))
            {
                int a = s.pop();
                int b = s.pop();
                s.push(b/a);
            }
            else
                s.push(Integer.valueOf(i));
        }
        return s.pop();
    }
}