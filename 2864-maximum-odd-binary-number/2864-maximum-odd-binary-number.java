class Solution 
{
    public String maximumOddBinaryNumber(String s) 
    {
        int n = s.length();
        char[] arr = s.toCharArray();
        int l = 0, r = n-1;
        while(l <= r)
        {
            if(arr[l] == '1') l++;
            if(arr[r] == '0') r--;
            if(l <= r && arr[l] == '0' && arr[r] == '1') 
            {
                arr[l] = '1';
                arr[r] = '0';
            }
        }
        
        arr[l-1] = '0';
        arr[n-1] = '1';
        
        return new String(arr);
    }
}