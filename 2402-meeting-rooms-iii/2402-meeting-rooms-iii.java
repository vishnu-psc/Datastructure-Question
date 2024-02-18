class Solution 
{
    public int mostBooked(int n, int[][] meetings) 
    {
        int m = meetings.length;
        
        Arrays.sort(meetings, (a, b)->Integer.compare(a[0], b[0]));
        
        long[] lastAvailableAt = new long[n];
        
        int[] roomUsedCount = new int[n];
        
        for(int[] meet: meetings)
        {
            int start = meet[0];
            int end = meet[1];
            int duration = end - start;
            boolean found = false;
            
            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;
            
            for(int room = 0; room < n; room++)
            {
                if(lastAvailableAt[room] <= start)
                {
                    lastAvailableAt[room] = end;
                    roomUsedCount[room]++;
                    found = true;
                    break;
                }
                
                if(lastAvailableAt[room] < earlyEndRoomTime)
                {
                    earlyEndRoomTime = lastAvailableAt[room];
                    earlyEndRoom = room;
                }
            }
            
            if(!found)
            {
                lastAvailableAt[earlyEndRoom] += duration;
                roomUsedCount[earlyEndRoom]++;
            }
        }
        
        int resultRoom = -1;
        int maxUsed = 0;
        
        for(int room = 0; room < n; room++)
        {
            if(roomUsedCount[room] > maxUsed)
            {
                maxUsed = roomUsedCount[room];
                resultRoom = room;
            }
        }
        
        return resultRoom;
    }
}