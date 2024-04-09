class Solution 
{
    public int timeRequiredToBuy(int[] ticket, int k) 
    {
        int n = ticket.length;
        int totalTime = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++)
        {
            q.add(i);
        }
        
        while(!q.isEmpty())
        {
            totalTime++;

            int front = q.poll();
            
            ticket[front]--;
            
            if(k == front && ticket[front] == 0) return totalTime;
            
            if(ticket[front] != 0) q.add(front);
            
        }
        return totalTime;
    }
}