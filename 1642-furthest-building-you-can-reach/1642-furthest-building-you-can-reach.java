class Solution 
{
    public int furthestBuilding(int[] h, int bricks, int ladders) 
    {
        int n = h.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < n-1; i++)
        {
            int diff = h[i+1] - h[i];
            if(diff <= 0) continue;
            bricks -= diff;
            pq.add(diff);
            
            if(bricks < 0)
            {
                bricks += pq.poll();
                if(ladders > 0) ladders--;
                else return i;
            }
        }
        return n-1;
        
    }
}