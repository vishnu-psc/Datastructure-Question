class Solution {
    public List<Integer> sequentialDigits(int low, int high) 
    {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= 8; i++)
        {
            q.add(i);
        }
        List<Integer> l = new ArrayList<>();
        
        while(!q.isEmpty())
        {
            int temp = q.peek();
            q.poll();
            if(temp >= low && temp <= high)
            {
                l.add(temp);
            }
            
            int last = temp %10;
            if(last + 1 < 10)
            {
                q.add(temp*10 + last+1);
            }
        }
        return l;
        
    }
}