class Solution {
    public int[] shortestToChar(String s, char c) {
        int right[]= new int[s.length()];
        int left[] = new int[s.length()];
        Arrays.fill(right , Integer.MAX_VALUE);
        Arrays.fill(left , Integer.MAX_VALUE);
        
        int count=Integer.MAX_VALUE;
        
        for(int i=0 ; i<right.length ; i++)
        {
            if(s.charAt(i)==c)
            {
                count=0;
                right[i]=count;
            }
            else
            {
                if(count!=Integer.MAX_VALUE)
                {
                    count++;
                    right[i]=count;
                }
            }
        }
        
         count=Integer.MAX_VALUE;
        
        for(int i=left.length-1 ; i>=0 ; i--)
        {
            if(s.charAt(i)==c)
            {
                count=0;
                left[i]=count;
            }
            else
            {
                if(count!=Integer.MAX_VALUE)
                {
                    count++;
                    left[i]=count;
                }
            }
        }
        
        int arr[]= new int[s.length()];
        for(int i=0 ;i<arr.length ; i++)
        {
            arr[i]=Math.min(right[i] , left[i]);
        }
        
        return arr;
   
    }
}